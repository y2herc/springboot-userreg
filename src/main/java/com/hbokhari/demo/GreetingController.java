package com.hbokhari.demo;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Controller
public class GreetingController extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/greeting").setViewName("greeting");
    }

    @GetMapping("/")
    public String showForm(User personForm) {
        return "helloform";
    }

    @PostMapping("/")
    public String checkPersonInfo(@Valid User personForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "helloform";
        }

        return "redirect:/greeting";
    }
}