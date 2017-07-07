package com.hbokhari.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.hbokhari.demo.model.User;
import com.hbokhari.demo.service.UserService;


@Controller
@EnableAutoConfiguration
public class GreetingController  {
	
	@Autowired
	private UserService userService;

    @GetMapping("/")
    public String showForm(User personForm) {
        return "helloform";
    }

    @PostMapping("/")
    public String checkPersonInfo(@Valid User personForm, BindingResult bindingResult,HttpServletRequest request, Model model) {

        if (bindingResult.hasErrors()) {
            return "helloform";
        }

        String name =request.getParameter("name");
		String password=request.getParameter("password");
		
		if(userService.userExists(name))
			return "useralreadyexists";

		else
			try {
		            User user = new User(name,password);
		            userService.create(user);
		        } catch (Exception e) {
	
		        }
		
	        model.addAttribute("name", name);
	        model.addAttribute("password", password);
	        
	        return "greeting"; 
    }
}    
