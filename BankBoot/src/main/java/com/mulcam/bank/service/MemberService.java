package com.mulcam.bank.service;

import com.mulcam.bank.vo.Member;

public interface MemberService {
	public boolean login(String id, String password) throws Exception;
	public void join(Member member) throws Exception;
}
