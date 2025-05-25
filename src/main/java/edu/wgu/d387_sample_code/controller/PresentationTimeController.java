package edu.wgu.d387_sample_code.controller;

import edu.wgu.d387_sample_code.service.PresentationTimeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/presentation-time")
public class PresentationTimeController {
    private final PresentationTimeService presentationTimeService;

    public PresentationTimeController(PresentationTimeService presentationTimeService) {
        this.presentationTimeService = presentationTimeService;
    }

    @GetMapping
    public String getPresentationTime() {
        // Example: 3:00 PM ET on May 30, 2025
        String localTime = "2025-05-30T15:00";
        return presentationTimeService.getPresentationTimes(localTime);
    }
} 