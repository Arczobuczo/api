package com.sda.demo.controller;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class HomePageController {

    @GetMapping("/")
    public String homePage(){

        return "home/homePage";
    }
}
