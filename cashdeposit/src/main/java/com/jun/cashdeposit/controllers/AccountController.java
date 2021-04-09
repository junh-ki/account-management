package com.jun.cashdeposit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jun.cashdeposit.entities.Account;
import com.jun.cashdeposit.services.AccountService;

@Controller
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping("/showCreate")
    public String createAccount(@RequestParam("userId") int id, ModelMap modelMap) {
    	modelMap.addAttribute("userId", id);
    	return "createAccount";
    }
	
	@RequestMapping("/saveAcc")
    public String saveAccount(@ModelAttribute("account") Account account, ModelMap modelMap) {
		Account accountSaved = accountService.saveAccount(account);
		String msg = "Account saved with id: " + accountSaved.getId();
        modelMap.addAttribute("msg", msg);
        return "createAccount";
    }
    
    @RequestMapping("/displayLocations")
    public String displayAccounts(ModelMap modelMap) {
    	List<Account> accounts = accountService.getAccountsOfUser(null);
    	modelMap.addAttribute("accounts", accounts);
        return "displayAccounts";
    }
	
}