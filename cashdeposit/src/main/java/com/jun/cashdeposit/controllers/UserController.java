package com.jun.cashdeposit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jun.cashdeposit.entities.User;
import com.jun.cashdeposit.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/showReg")
    public String showRegistrationPage() {
        return "login/registerUser";
    }
    
    @RequestMapping("/showLogin")
    public String showLoginPage() {
        return "login/login";
    }
    
    @RequestMapping(value="/registerUser", method=RequestMethod.POST)
    public String register(@ModelAttribute("user") User user) {
    	userService.saveUser(user);
        return "login/login";
    }
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String login(@RequestParam("email") String email, @RequestParam("password") String password, ModelMap modelMap) {
        User user = userService.findUserByEmail(email);
        if (user.getPassword().equals(password)) {
        	modelMap.addAttribute("user", user);
            return "userhome";
        }
        modelMap.addAttribute("msg", "Invalid user name or password. Please try again.");
        return "login/login";
    }
    
}