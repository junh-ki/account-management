package com.jun.cashdeposit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jun.cashdeposit.integration.AccountRestClient;
import com.jun.cashdeposit.integration.DepositRestClient;
import com.jun.cashdeposit.integration.dto.Account;
import com.jun.cashdeposit.integration.dto.AccountUpdateRequest;
import com.jun.cashdeposit.integration.dto.Deposit;

@Controller
public class DepositController {
	
	@Autowired
	private AccountRestClient accountRestClient;
	
	@Autowired
	private DepositRestClient depositRestClient;
	
	@RequestMapping("/showDeposit")
    public String showCompleteReservation(@RequestParam("accountId") Long accountId, ModelMap modelMap) {
		Account account = accountRestClient.findAccountById(accountId);
        modelMap.addAttribute("account", account);
        return "completeDeposit";
    }
	
	@RequestMapping("/completeDeposit")
	public String completeDeposit(@RequestParam("accountId") Long accountId, @RequestParam("amount") Double amount, ModelMap modelMap) {
		Deposit deposit = new Deposit();
		deposit.setAccountId(accountId);
		deposit.setAmount(amount);
		Account account = accountRestClient.findAccountById(accountId);
		Double newBalance = account.getBalance() + amount;
		// Renew balance & Update account with the renewed balance
		AccountUpdateRequest accountUpdateRequest = new AccountUpdateRequest();
		accountUpdateRequest.setId(accountId);
		accountUpdateRequest.setBalance(newBalance);
		accountRestClient.updateAccount(accountUpdateRequest);
		Deposit savedDeposit = depositRestClient.saveDeposit(deposit);
		modelMap.addAttribute("msg", "Deposit created successfully and the id is " + savedDeposit.getId());
		modelMap.addAttribute("holderId", account.getHolderId());
        return "depositConfirmation";
	}
	
}
