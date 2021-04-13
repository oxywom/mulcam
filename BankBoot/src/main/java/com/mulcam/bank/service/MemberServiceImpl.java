package com.mulcam.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mulcam.bank.dao.MemberDAO;
import com.mulcam.bank.vo.Member;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAO memberDAO;
	@Override
	public boolean login(String id, String password) throws Exception {
		Member member=memberDAO.selectMember(id);
		if(member==null) throw new Exception("아이디 오류");
		if(member.getPassword().equals(password)) {
			return true;
		}
		return false;
	}
	@Override
	public void join(Member member) throws Exception {
		Member smember = memberDAO.selectMember(member.getId());
		if(smember!=null) throw new Exception("아이디 중복");
		memberDAO.insertMember(member);
	}
}
