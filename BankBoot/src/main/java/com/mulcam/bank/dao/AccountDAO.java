package com.mulcam.bank.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mulcam.bank.vo.Account;

@Mapper
@Repository("accountDAO")
public interface AccountDAO {
	public void insertAccount(Account acc) throws Exception;
	public Account selectAccount(String id) throws Exception;
	public void updateAccount(Account acc) throws Exception;
	public List<Account> selectAllAccountList() throws Exception;

}
