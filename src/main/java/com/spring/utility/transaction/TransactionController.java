package com.spring.utility.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TransactionController {

	@Autowired
	private TransactionService transactionService;
	
	@GetMapping("/addAccountTransfer")
	public String addAccountTransfer(){
		transactionService.addAccountTransfer();
		return "home";
	}
	
	
	@GetMapping("/addOrder")
	public String addOrder() {
		transactionService.addOrder();
		return "home";
	}
	
}
