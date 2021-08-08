package com.coffee.shop.web;

import com.coffee.shop.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.awt.*;


@Controller
public class HomeController {


    @GetMapping("/")
    public String displayMainPage(){
        return "home";
        }

//home    @PostMapping
//    public String displayMenu( @ModelAttribute Menu menu) {
//        return "redirect:/menu";
//    }
}
