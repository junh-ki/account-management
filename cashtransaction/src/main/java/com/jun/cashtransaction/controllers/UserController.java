package com.jun.cashtransaction.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jun.cashtransaction.integration.UserRestClient;
import com.jun.cashtransaction.integration.dto.User;

@Controller
public class UserController {
	
	@Autowired
	private UserRestClient userRestClient;
	
	@RequestMapping("/showLogin")
    public String showLoginPage() {
        return "login";
    }
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
    public String login(@RequestParam("email") String email, @RequestParam("password") String password, ModelMap modelMap) {
		User user = userRestClient.findUser(email);
		if (user.getPassword().equals(password)) {
			modelMap.addAttribute("user", user);
            return "userhome";
		}
        modelMap.addAttribute("msg", "Invalid user name or password. Please try again.");
        return "login";
    }
}
