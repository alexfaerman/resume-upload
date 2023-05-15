package com.workwolf.docupload.resume;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ResumeService {

    private List<Education>  educationList;
    private List<Experience> pastExperienceList;
    private static final String regex = "^(.*),\\s*(.*),\\s*(.*)\\s*-\\s*(.*)$";
    private static final Pattern pattern = Pattern.compile(regex);

    public List<Experience> getPastExperience(MultipartFile file)  throws IOException {

        boolean educationFlag = false;
        educationList = new ArrayList<>();
        pastExperienceList = new ArrayList<>();

        try (
            Reader reader1 = new InputStreamReader(file.getInputStream());
            BufferedReader reader = new BufferedReader(reader1)) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains("education")) {
                    educationFlag = true;
                    continue;
                }
                if (line.toLowerCase().contains("experience")) {
                    educationFlag = false;
                }
                if (educationFlag) {
                    continue;
                }
                Matcher matcher = pattern.matcher(line);
                if (matcher.matches()) {
                    String jobTitle = matcher.group(1).trim();
                    String companyName = matcher.group(2).trim();
                    String startDate = matcher.group(3).trim();
                    String endDate = matcher.group(4).trim();
                    Experience experience = new Experience(jobTitle, companyName, startDate, endDate);
                    pastExperienceList.add(experience);
                }
            }
            return pastExperienceList;
        }
    }

    public List<Education> getEducation(MultipartFile file) throws IOException {

        boolean experienceFlag = false;
        educationList = new ArrayList<>();
        pastExperienceList = new ArrayList<>();

        try (
            Reader reader1 = new InputStreamReader(file.getInputStream());
            BufferedReader reader = new BufferedReader(reader1)) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains("experience")) {
                    experienceFlag = true;
                    continue;
                }
                if (line.toLowerCase().contains("education")) {
                    experienceFlag = false;
                }
                if (experienceFlag) {
                    continue;
                }
                Matcher matcher = pattern.matcher(line);
                if (matcher.matches()) {
                    String degree = matcher.group(1).trim();
                    String institution = matcher.group(2).trim();
                    String startDate = matcher.group(3).trim();
                    String endDate = matcher.group(4).trim();
                    Education education = new Education(degree, institution, startDate, endDate);
                    educationList.add(education);
                }
            }
            return educationList;
        }
    }

}


