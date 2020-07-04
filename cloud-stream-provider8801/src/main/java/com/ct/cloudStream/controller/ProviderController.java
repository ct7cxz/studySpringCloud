package com.ct.cloudStream.controller;

import com.ct.cloudStream.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {

    @Autowired
    private ProviderService providerService;

    @GetMapping(path = "/send")
    public String sendProvider() {
        return providerService.send();
    }
}
