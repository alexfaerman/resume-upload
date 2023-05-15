package com.workwolf.docupload.resume;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

@Controller
public class ResumeController {
    private final ResumeService resumeService;

    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @RequestMapping(value="/upload", method = RequestMethod.POST)
    public String uploadResume(@RequestParam("file") MultipartFile file, Model model) {
        try {
            List<Education> education = resumeService.getEducation(file);
            List<Experience> pastExperience = resumeService.getPastExperience(file);
            model.addAttribute("educationList", education);
            model.addAttribute("pastExperienceList", pastExperience);
        } catch (IOException e) {
            // error reading the file
            model.addAttribute("message", "Error uploading resume or reading the file.");
       }

       return "doneResume";
    }

    @RequestMapping("/resume")
    public String uploadResume(){
        return "resume";
    }
}
