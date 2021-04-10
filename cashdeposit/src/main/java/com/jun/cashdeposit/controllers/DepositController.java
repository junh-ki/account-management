package com.jun.cashdeposit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jun.cashdeposit.dto.DepositRequest;
import com.jun.cashdeposit.entities.Account;
import com.jun.cashdeposit.entities.Deposit;
import com.jun.cashdeposit.services.AccountService;
import com.jun.cashdeposit.services.DepositService;

@Controller
public class DepositController {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private DepositService depositService;
	
	@RequestMapping("/showDeposit")
    public String showCompleteReservation(@RequestParam("accountId") Long accountId, ModelMap modelMap) {
		Account account = accountService.getAccountById(accountId);
        modelMap.addAttribute("account", account);
        return "completeDeposit";
    }
	
	@RequestMapping("/completeDeposit")
	public String completeDeposit(@RequestParam("accountId") Long accountId, @RequestParam("amount") Double amount, ModelMap modelMap) {
		DepositRequest request = new DepositRequest();
		request.setAccountId(accountId);
		request.setAmount(amount);
		Deposit deposit = depositService.depositCash(request);
		modelMap.addAttribute("msg", "Deposit created successfully and the id is " + deposit.getId());
        return "depositConfirmation";
	}
	
}
