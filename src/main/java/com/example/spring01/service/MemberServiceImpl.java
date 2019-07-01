package com.example.spring01.service;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring01.model.dao.MemberDAO;
import com.example.spring01.model.dto.MemberDTO;
@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDAO memberDao;

	@Override
	public List<MemberDTO> memberList() {
		return memberDao.memberList();
	}

	@Override
	public void insertMember(MemberDTO dto) {
		memberDao.insertMember(dto);
		
	}

	@Override
	public MemberDTO viewMember(String userid) {
		return memberDao.viewMember(userid);
	}

	@Override
	public void deleteMember(String userid) {
		memberDao.deleteMember(userid);
	}

	@Override
	public void updateMember(MemberDTO dto) {
		memberDao.updateMember(dto);
		
	}

	@Override
	public boolean checkPw(String userid, String passwd) {
		return memberDao.checkPw(userid, passwd);
	}

	@Override
	public String loginCheck(MemberDTO dto, HttpSession session) {
		String name = memberDao.loginCheck(dto);
		if(name!=null) {
			//세션변수등록
			session.setAttribute("userid", dto.getUserid());
			session.setAttribute("name", name);
		}
		return name;
	}

	@Override
	public void logout(HttpSession session) {
		//세션초기화
		session.invalidate();
	}

	
	
	
//
//	@Override
//	public List<MemberDTO> memberList() {
//		return memberDao.memberList();
//	}
//
//	@Override
//	public void insertMember(MemberDTO dto) {
//		memberDao.insertMember(dto);
//	}
//
//	@Override
//	public MemberDTO viewMember(String userid) {
//		return memberDao.viewMember(userid);
//	}
////	public MemberDTO viewMember(String userid) {
////		return memberDao.viewMember(userid);
////	}
//
//	@Override
//	public void deleteMember(String userid) {
//		memberDao.deleteMember(userid);
//	}
//
//	@Override
//	public void updateMember(MemberDTO dto) {
//		memberDao.updateMember(dto);
//	}
//
//	@Override
//	public boolean checkPw(String userid, String passwd) {
//		return memberDao.checkPw(userid, passwd);
//	}
//	
//	@Override
//	public List<MemberDTO> memberList() {
//		return 	memberDao.memberList();
//	}
//
//	@Override
//	public void insertMember(MemberDTO dto) {
//		memberDao.insertMember(dto);
//	}
//
//	@Override
//	public MemberDTO viewMember(String userid) {
//		return memberDao.viewMember(userid);
//	}
//
//	@Override
//	public void deleteMember(String userid) {
//		memberDao.deleteMember(userid);
//	}
//
//	@Override
//	public void updateMember(MemberDTO dto) {
//		memberDao.updateMember(dto);
//
//	}
//
//	@Override
//	public boolean checkPw(String userid, String passwd) {
//		return memberDao.checkPw(userid, passwd);
//	}
//
}
