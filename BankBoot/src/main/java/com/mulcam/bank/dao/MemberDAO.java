package com.mulcam.bank.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mulcam.bank.vo.Member;

@Mapper
@Repository("memberDAO")
public interface MemberDAO {
	public void insertMember(Member mem) throws Exception;
	public Member selectMember(String id) throws Exception;
}
