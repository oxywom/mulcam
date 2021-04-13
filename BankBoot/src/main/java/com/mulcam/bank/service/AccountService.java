package com.mulcam.bank.service;

import java.util.List;

import com.mulcam.bank.vo.Account;

public interface AccountService {
	public void makeAccount(Account acc) throws Exception;
	public void deposit(String id, int money) throws Exception;
	public void withdraw(String id, int money) throws Exception;
	public Account accountInfo(String id) throws Exception;
	public List<Account> allAccountInfo() throws Exception;
}
