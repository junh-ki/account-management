package com.jun.cashtransaction.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jun.cashtransaction.integration.AccountRestClient;
import com.jun.cashtransaction.integration.ExchangeRateRestClient;
import com.jun.cashtransaction.integration.TransactionRestClient;
import com.jun.cashtransaction.integration.dto.Account;
import com.jun.cashtransaction.integration.dto.AccountUpdateRequest;
import com.jun.cashtransaction.integration.dto.Transaction;

@Controller
public class TransactionController {
	
	@Autowired
	private AccountRestClient accountRestClient;
	
	@Autowired
	private ExchangeRateRestClient exchangeRateRestClient;
	
	@Autowired
	private TransactionRestClient transactionRestClient;
	
	@RequestMapping("/showTransaction")
	public String showCompleteTransaction(@RequestParam("accountId") Long accountId, ModelMap modelMap) {
		Account account = accountRestClient.findAccountById(accountId);
		modelMap.addAttribute("account", account);
		return "completeTransaction";
	}
	
	@RequestMapping("/completeTransaction")
	public String completeTransaction(@RequestParam("senderAccountID") Long senderAccountID, @RequestParam("recipientAccountID") Long recipientAccountID,
			@RequestParam("amount") Double amount, ModelMap modelMap) {
		Account senderAccount = accountRestClient.findAccountById(senderAccountID);
		Account recipientAccount = accountRestClient.findAccountById(recipientAccountID);
		String senderCurrency = senderAccount.getCurrency();
		String recipientCurrency = recipientAccount.getCurrency();
		if (senderAccount.getBalance() > amount) {
			// A. Transaction (Send)
			Transaction transaction = new Transaction();
			transaction.setSendAmount(amount);
			transaction.setSendCurrency(senderCurrency);
			transaction.setSenderAccountId(senderAccount.getId());
			// 1. Decrease sender's balance
			AccountUpdateRequest senderUpdateRequest = new AccountUpdateRequest();
			Double newSenderBalance = senderAccount.getBalance() - amount;
			senderUpdateRequest.setBalance(newSenderBalance);
			senderUpdateRequest.setId(senderAccount.getId());
			accountRestClient.updateAccount(senderUpdateRequest);
			// 2. Increase recipient's balance
			AccountUpdateRequest recipientUpdateRequest = new AccountUpdateRequest();
			if (senderCurrency.compareTo(recipientCurrency) != 0) {
				Double euroBasedUsdExchange = exchangeRateRestClient.getEuroBasedUsdExchangeRate();
				modelMap.addAttribute("eurusdrate", euroBasedUsdExchange);
				if (senderCurrency.compareTo("EUR") == 0) {
					amount = amount * euroBasedUsdExchange;
				} else {
					amount = amount / euroBasedUsdExchange;
				}
				amount = Math.round(amount * 100.0) / 100.0;
			}
			Double newRecipientBalance = recipientAccount.getBalance() + amount;
			recipientUpdateRequest.setBalance(newRecipientBalance);
			recipientUpdateRequest.setId(recipientAccount.getId());
			accountRestClient.updateAccount(recipientUpdateRequest);
			// B. Transaction (Receive)
			transaction.setReceiveAmount(amount);
			transaction.setReceiveCurrency(recipientCurrency);
			transaction.setRecipientAccountId(recipientAccountID);
			transactionRestClient.saveTransaction(transaction);
			// 3. ModelMap
			modelMap.addAttribute("transaction", transaction);
			modelMap.addAttribute("newbalance", newSenderBalance);
			modelMap.addAttribute("holderId", senderAccount.getHolderId());
			return "transactionConfirmation";
		} else {
			String msg = "Your balance is less than the transaction amount of " + amount + " " + senderCurrency;
			modelMap.addAttribute("msg", msg);
			return "completeTransaction";
		}
	}
	
}
