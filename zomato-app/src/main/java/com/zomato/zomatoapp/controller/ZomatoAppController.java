package com.zomato.zomatoapp.controller;

import com.zomato.zomatoapp.ZomatoAppApplication;
import com.zomato.zomatoapp.dto.OrderResponseDTO;
import com.zomato.zomatoapp.service.ZomatoAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/zomato")
public class ZomatoAppController {

    @Autowired
    private ZomatoAppService zomatoAppService;

    @GetMapping
    public String greetingMsg(){
        return zomatoAppService.greeting();
    }

    @GetMapping("/{orderId}")
    public OrderResponseDTO checkStatus(@PathVariable String orderId){
        return zomatoAppService.checkStatus(orderId);
    }

}
