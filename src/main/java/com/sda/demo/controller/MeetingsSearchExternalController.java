package com.sda.demo.controller;

import com.sda.demo.Dtos.MeetingShortInfoDto;
import com.sda.demo.config.RestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("ext")
public class MeetingsSearchExternalController {
    private final RestService restService;

    public MeetingsSearchExternalController(RestService restService) {
        this.restService = restService;
    }


    @GetMapping("/meetings-search")
    public String getAllMeetingsFromAPI(
            @RequestParam() String search,
            @RequestParam() Short period,
            Model model){

        String url = String.format("http://localhost:9999/api/meetings?search=%s&period=%s", search, period);

        List<MeetingShortInfoDto> meetings = restService.getForObject(url, List.class);
        log.info("Meetings {}", meetings);

        model.addAttribute("meetings", meetings);

        return "api/meetingsFormViwe";
    }
}
