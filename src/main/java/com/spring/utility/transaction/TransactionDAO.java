package com.spring.utility.transaction;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TransactionDAO {

	public void updateSendMoney();
	public void updateRecvMoney();
	
	public void updatePoint();
	public void updateCartCnt();
	public void updateOrderCnt();
	
}
