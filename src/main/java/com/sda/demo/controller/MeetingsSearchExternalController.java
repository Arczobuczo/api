package com.sda.demo.controller;

import com.sda.demo.Dtos.MeetingShortInfoDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("ext")
public class MeetingsSearchExternalController {
    private final RestTemplate restTemplate;

    public MeetingsSearchExternalController(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }


    @GetMapping("/meetings-search")
    public String getAllMeetingsFromAPI(
            @RequestParam() String search,
            @RequestParam() Short period,
            Model model){

        String url = String.format("http://localhost:9999/api/meetings?search=%s&period=%s", search, period);

        List<MeetingShortInfoDto> meetings = restTemplate.getForObject(url, List.class);
        log.info("Meetings {}", meetings);

        model.addAttribute("meetings", meetings);

        return "api/meetingsFormViwe";
    }
}
