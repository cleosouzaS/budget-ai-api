package com.cleosouza.budget_ai_api.controller;

import com.cleosouza.budget_ai_api.service.IAService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IAController {

    private final IAService iaService;

    public IAController(IAService iaService) {
        this.iaService = iaService;
    }

    @GetMapping("/ia")
    public String perguntar(@RequestParam String pergunta) {
        return iaService.perguntar(pergunta);
    }
}