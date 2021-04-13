package com.mulcam.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mulcam.bank.dao.AccountDAO;
import com.mulcam.bank.vo.Account;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountDAO accountDAO;

	@Override
	public void makeAccount(Account acc) throws Exception {
		Account sacc = accountDAO.selectAccount(acc.getId());
		if(sacc!=null) {
			throw new Exception("계좌번호 중복");
		} else {
			if(acc.getGrade()==null) acc.setGrade("");
			accountDAO.insertAccount(acc);
		}
	}

	@Override
	public void deposit(String id, int money) throws Exception {
		Account acc = accountDAO.selectAccount(id);
		if(acc==null) {
			throw new Exception("계좌번호 오류");
		} else {
			acc.deposit(money);
			accountDAO.updateAccount(acc);
		}
	}

	@Override
	public void withdraw(String id, int money) throws Exception {
		Account acc = accountDAO.selectAccount(id);
		if(acc==null) {
			throw new Exception("계좌번호 오류");
		} else {
			acc.withdraw(money);
			accountDAO.updateAccount(acc);
		}
	}

	@Override
	public Account accountInfo(String id) throws Exception {
		return accountDAO.selectAccount(id);
	}

	@Override
	public List<Account> allAccountInfo() throws Exception {
		// TODO Auto-generated method stub
		return accountDAO.selectAllAccountList();
	}

}
