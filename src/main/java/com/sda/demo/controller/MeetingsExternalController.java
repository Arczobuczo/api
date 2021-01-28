package com.sda.demo.controller;

import com.sda.demo.Dtos.MeetingShortInfoDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("ext")
public class MeetingsExternalController {

    private final RestTemplate restTemplate;

    public MeetingsExternalController(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }


    @GetMapping("/meetings")
    public String getAllMeetingsFromAPI(
            Model model){
    List<MeetingShortInfoDto> meetings = restTemplate.getForObject("http://localhost:9999/api/meetings?search=&period=3", List.class);
        log.info("Meetings {}", meetings);

        model.addAttribute("meetings", meetings);

        return "api/meetingsFormViwe";
    }
}
