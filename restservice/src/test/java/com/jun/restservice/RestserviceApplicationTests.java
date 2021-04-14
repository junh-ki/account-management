package com.jun.restservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jun.restservice.entities.Account;
import com.jun.restservice.entities.Deposit;
import com.jun.restservice.entities.Transaction;
import com.jun.restservice.entities.User;
import com.jun.restservice.services.AccountService;
import com.jun.restservice.services.DepositService;
import com.jun.restservice.services.TransactionService;
import com.jun.restservice.services.UserService;

@SpringBootTest
class RestserviceApplicationTests {

	@Autowired
	private UserService userService;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private DepositService depositService;
	
	@Autowired
	private TransactionService transactionService;
	
	@Test
	public void testUserCreate() {
		User user = new User();
		user.setId(1l);
		user.setFirstName("Junhyung");
		user.setLastName("Ki");
		user.setEmail("kijoonh91@gmail.com");
		user.setPassword("1234567890");
		userService.saveUser(user);
		User savedUser = userService.findUserById(1l);
		assertNotNull(savedUser);
		assertEquals(1l, savedUser.getId());
		assertEquals("Junhyung", savedUser.getFirstName());
		assertEquals("Ki", savedUser.getLastName());
		assertEquals("kijoonh91@gmail.com", savedUser.getEmail());
		assertEquals("1234567890", savedUser.getPassword());
	}
	
	@Test 
	public void testAccountCreate() {
		Account account = new Account();
		account.setId(1l);
		account.setCurrency("EUR");
		account.setBalance(123.45d);
		account.setHolderId(1l);
		accountService.saveAccount(account);
		Account savedAccount = accountService.getAccountById(1l);
		assertNotNull(savedAccount);
		assertEquals(1l, savedAccount.getId());
		assertEquals("EUR", savedAccount.getCurrency());
		assertEquals(123.45d, savedAccount.getBalance());
		assertEquals(1l, savedAccount.getHolderId());
	}
	
	@Test
	public void testDepositCreate() {
		Deposit deposit = new Deposit();
		deposit.setId(1l);
		deposit.setAmount(123.45d);
		deposit.setAccountId(1l);
		depositService.saveDeposit(deposit);
		Deposit savedDeposit = depositService.findDepositById(1l);
		assertNotNull(savedDeposit);
		assertEquals(1l, savedDeposit.getId());
		assertEquals(123.45d, savedDeposit.getAmount());
		assertEquals(1l, savedDeposit.getAccountId());
	}
	
	@Test
	public void testTransactionCreate() {
		Transaction transaction = new Transaction();
		transaction.setId(1l);
		transaction.setSendAmount(123.45d);
		transaction.setSendCurrency("EUR");
		transaction.setSenderAccountId(1l);
		transaction.setReceiveAmount(123.45d);
		transaction.setReceiveCurrency("EUR");
		transaction.setRecipientAccountId(2l);
		transactionService.saveTransaction(transaction);
		Transaction savedTransaction = transactionService.getTransactionById(1l);
		assertNotNull(savedTransaction);
		assertEquals(1l, savedTransaction.getId());
		assertEquals(123.45d, savedTransaction.getSendAmount());
		assertEquals("EUR", savedTransaction.getSendCurrency());
		assertEquals(1l, savedTransaction.getSenderAccountId());
		assertEquals(123.45d, savedTransaction.getReceiveAmount());
		assertEquals("EUR", savedTransaction.getReceiveCurrency());
		assertEquals(2l, savedTransaction.getRecipientAccountId());
	}

}
