package com.workwolf.docupload.resume;

import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ResumeController {
    private final ResumeService resumeService;

    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
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

    @GetMapping(value = "/get-json")
    public Map<String, Object> get(@RequestParam("file") MultipartFile file) {
        Map<String, Object> map = new HashMap<>();
        try {
            List<Education> education = resumeService.getEducation(file);
            List<Experience> pastExperience = resumeService.getPastExperience(file);
            map.put("education", education);
            map.put("pastExperience", pastExperience);
        } catch (IOException e) {
            // error reading the file
            map.put("message", "Error uploading resume or reading the file.");
        }
        return map;
    }


    @RequestMapping("/resume")
    public String uploadResume(){
        return "resume";
    }
}
