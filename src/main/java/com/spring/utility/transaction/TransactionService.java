package com.spring.utility.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionService {

	/*
	  
	   [ 스프링 트랜잭션 구현 방법 ]
	  
	  @Transactional어노테이션 추가 후 트랜잭션을 구현한다.
	  
	*/
	
	@Autowired
	private TransactionDAO transactionDAO;
	
	@Transactional
	public void addAccountTransfer() {
	
		transactionDAO.updateSendMoney();
		System.out.println(0/0); // 에러 발생
		transactionDAO.updateRecvMoney();
		
	}
	
	@Transactional
	public void addOrder() {
		
		transactionDAO.updatePoint();
		transactionDAO.updateCartCnt();
		System.out.println(0/0); // 에러 발생
		transactionDAO.updateOrderCnt();
		
	}
	
	
}
