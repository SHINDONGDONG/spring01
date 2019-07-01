package com.example.spring01.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.spring01.model.dto.MemberDTO;
@Repository
public class MemberDAOImpl implements MemberDAO {

	private static final Logger logger = 
			LoggerFactory.getLogger(MemberDAOImpl.class);
	
	@Autowired//마이바티스 의존관계 주입
	SqlSession sqlSession;

	@Override
	public List<MemberDTO> memberList() {
		return sqlSession.selectList("member.listMember");
	}

	@Override
	public void insertMember(MemberDTO vo) {
		sqlSession.insert("member.insertMember",vo);
		
	}

	@Override
	public MemberDTO viewMember(String userid) {
		return sqlSession.selectOne("member.viewMember",userid);
	}

	@Override
	public void deleteMember(String userid) {
		sqlSession.selectOne("member.deleteMember",userid);
		
	}

	@Override
	public void updateMember(MemberDTO vo) {
		sqlSession.selectOne("member.updateMember",vo);
	}

	@Override
	public boolean checkPw(String userid, String passwd) {
		boolean result = false;
		Map<String,String> map = new HashMap<>();
		map.put("userid", userid);
		map.put("passwd", passwd);
		int count = sqlSession.selectOne("member.checkPw",map);
		if(count == 1)result=true;
		return result;
	}

	@Override
	public String loginCheck(MemberDTO dto) {
		return sqlSession.selectOne("member.login_check",dto);
	}
	
	
//	
//	@Override
//	public List<MemberDTO> memberList() {
//		//sql mapper 에서 실행되면 자동으로 commit & close
//		logger.info("memberList colled...");
//		return sqlSession.selectList("member.memberList");
//	}
//
//	@Override
//	public void insertMember(MemberDTO vo) {
//		sqlSession.insert("member.insertMember",vo);
//	}
//
//	@Override
//	public MemberDTO viewMember(String userid) {
//		return sqlSession.selectOne("member.viewMember",userid);
//	}
//
//	@Override
//	public void deleteMember(String userid) {
//		sqlSession.selectOne("member.deleteMember",userid);
//
//	}
//
//	@Override
//	public void updateMember(MemberDTO vo) {
//		sqlSession.update("member.updateMember", vo);
//	}
//
//	@Override
//	public boolean checkPw(String userid, String passwd) {
//		boolean result=false;
//		Map<String,String> map = new HashMap<>();
//		map.put("userid",userid);
//		map.put("passwd",passwd);
//		int count = sqlSession.selectOne("member.checkPw",map);
//		//리턴값이 1이면 트루
//		if(count == 1)result =true;
//		return result;
//			
//				
//	}
//
//	@Override
//	public List<MemberDTO> memberList() {
//		return sqlSession.selectList("member.memberList");
//	}
//
//	@Override
//	public void insertMember(MemberDTO vo) {
//		sqlSession.insert("member.insertMember",vo);
//	}
//
//	@Override
//	public MemberDTO viewMember(String userid) {
//		return sqlSession.selectOne("member.viewMember",userid);
//	}
////	public MemberDTO viewMember(String userid) {
////		return sqlSession.selectOne("member.viewMember",userid);
////	}
//
//	@Override
//	public void deleteMember(String userid) {
//		sqlSession.selectOne("member.deleteMember",userid);
//	}
//
//	@Override
//	public void updateMember(MemberDTO vo) {
//		sqlSession.selectOne("member.updateMember",vo);
//	}
//
//	@Override
//	public boolean checkPw(String userid, String passwd) {
//		boolean result = false;
//		Map<String, String> map= new HashMap<>();
//		map.put("userid",userid);
//		map.put("passwd",passwd);
//		int count = sqlSession.selectOne("member.checkPw",map);
//		if(count==1)result=true;
//		return result;
//	}

}
