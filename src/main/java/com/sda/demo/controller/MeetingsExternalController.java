package com.sda.demo.controller;

import com.sda.demo.Dtos.MeetingShortInfoDto;
import com.sda.demo.config.RestTemplateConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("ext")
public class MeetingsExternalController {

    private final RestTemplateConfig restTemplateConfig;

    public MeetingsExternalController(RestTemplateConfig restTemplateConfig) {
        this.restTemplateConfig = restTemplateConfig;
    }


    @GetMapping("/meetings")
    public String getAllMeetingsFromAPI(
            Model model){
    List<MeetingShortInfoDto> meetings = restTemplateConfig.getForObject("http://localhost:9999/api/meetings?search=&period=3", List.class);
        log.info("Meetings {}", meetings);

        model.addAttribute("meetings", meetings);

        return "api/meetingsFormViwe";
    }
}
