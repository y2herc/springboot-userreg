package com.hbokhari.demo;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GreetingController {

    @RequestMapping(value="/greeting",method=RequestMethod.GET)
    public String helloform() {

        return "helloform";
    }
	@RequestMapping(value="/greeting",method=RequestMethod.POST)
    public String greeting(HttpServletRequest request, Model model) {
		
		String name =request.getParameter("name");
		String password=request.getParameter("password");
		
		
		
        model.addAttribute("name", name);
        model.addAttribute("password", password);
        
        return "greeting";
    }

}