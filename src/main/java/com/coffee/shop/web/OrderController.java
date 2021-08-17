package com.coffee.shop.web;

import com.coffee.shop.Customer;

import com.coffee.shop.data.CustomerRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;


import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("customer")
public class OrderController {

    private CustomerRepository customerRepository;


    public OrderController( CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/current")
    public String displayCustomer(){
        return "orderForm";
    }


    @PostMapping
    public String processOrder(@Valid Customer customer, Errors errors, SessionStatus sessionStatus) {
        if (errors.hasErrors()) {
            return "orderForm";
        }

        customerRepository.save(customer);
        sessionStatus.setComplete();

        return "redirect:/";
    }




}
