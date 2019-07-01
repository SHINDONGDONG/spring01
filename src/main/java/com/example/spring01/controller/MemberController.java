package com.example.spring01.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.spring01.model.dto.MemberDTO;
import com.example.spring01.service.MemberService;

@Controller
public class MemberController {
	
	private static final Logger logger = 
			LoggerFactory.getLogger(MainController.class);

	@Autowired
	MemberService memberService;
	
	

	@RequestMapping("member/list1.do")
	public String memberList(Model model) {
		List<MemberDTO> list = memberService.memberList();
		model.addAttribute("list", list);
		return "member/member_list1";
	}	
	
	@RequestMapping("member/write1.do")
	public String write() {
		return "member/write1";
	}
	
	@RequestMapping("member/insert1.do")
	public String insert(MemberDTO dto) {
		memberService.insertMember(dto);
		return "redirect:/member/list1.do";
	}
	
	@RequestMapping("member/view1.do")
	public String view(@RequestParam String userid,Model model) {
		MemberDTO dto = memberService.viewMember(userid);
		model.addAttribute("dto", dto);
		return "member/view1";
	}
	
	@RequestMapping("member/delete1.do")
	public String delete(@RequestParam String userid, @RequestParam String passwd,Model model) {
		boolean result = memberService.checkPw(userid, passwd);
		logger.info("로그인"+result);
		if(result) {
			memberService.deleteMember(userid);
			return "redirect:/member/list1.do";
		}else {
			model.addAttribute("dto", memberService.viewMember(userid));
			model.addAttribute("message", "삭제 비밀번호 틀렷슈~");
			return "member/view1";
			
		}
	}
	
	@RequestMapping("member/update1.do")
	public String update(@ModelAttribute MemberDTO dto,Model model) {
		boolean result = memberService.checkPw(dto.getUserid(), dto.getPasswd());
		
		if(result) {
			memberService.updateMember(dto);
			return "redirect:/member/list1.do";
		}else {
			model.addAttribute("dto",memberService.viewMember(dto.getUserid()));
			model.addAttribute("message", "수정 비밀번호가 틀렷슈~");
			return "member/view1";	
		}
		
	}
}
	
	/*	
	@RequestMapping("member/list1.do")
	public String memberList(Model model) {
		List<MemberDTO> list = memberService.memberList();
		logger.info("회원목록~ : "+list);
		model.addAttribute("list", list);
		return "member/member_list1";
	}
	
	@RequestMapping("member/write1.do")
	public String write() {
		return "member/write1";
	}
	
	@RequestMapping("member/insert1.do")
	public String insert1(MemberDTO dto) {
		memberService.insertMember(dto);
		return "redirect:/member/list1.do";
	}
	
	@RequestMapping("member/view1.do")
	public String view(@RequestParam String userid,Model model) {
		model.addAttribute("dto", memberService.viewMember(userid));
		return "member/view1";
	}
//	public String view(@RequestParam String userid,Model model) {
//	model.addAttribute("dto", memberService.viewMember(userid));
//	return "member/view";
//}
	
	@RequestMapping("member/delete1.do")
	public String delete(@RequestParam String userid,@RequestParam String passwd,Model model) {
		boolean result = memberService.checkPw(userid, passwd);
		if(result) {
			memberService.deleteMember(userid);
			return "redirect:/member/list1.do";
		}else {
			model.addAttribute("dto", memberService.viewMember(userid));
			model.addAttribute("message", "비밀번호가 불일치!");
			return "member/view1";
		}
	}
	
	@RequestMapping("member/update1.do")
	public String update(@ModelAttribute MemberDTO dto,Model model) {
		
		boolean result = memberService.checkPw(dto.getUserid(), dto.getPasswd());
		logger.info("비밀번호확인"+result);
		
		if(result) {
			memberService.updateMember(dto);
			return "redirect:/member/list1.do";
		}else {
			MemberDTO dto2 = memberService.viewMember(dto.getUserid());
			dto.setJoin_date(dto2.getJoin_date());
			model.addAttribute("dto", dto);
			model.addAttribute("message", "비밀번호 불이릴리리릴치");
			return "member/view1";
		}
		
		
*/
		
		//		@RequestMapping("member/update.do")
//		public String update(@ModelAttribute MemberDTO dto,Model model) {
//			boolean result = memberService.checkPw(dto.getUserid(), dto.getPasswd());
//			logger.info("비밀번호확인:"+result);
//			if(result) {
//		memberService.updateMember(dto);
//		return "redirect:/member/list.do";
//	}else {
//		MemberDTO dto2 = memberService.viewMember(dto.getUserid());
//		dto.setJoin_date(dto2.getJoin_date());
//		model.addAttribute("dto",dto);
//		model.addAttribute("message", "비밀번호가 불일치합니다");
//		return "member/view";
//	}
		
	
//	public String delete(@RequestParam String userid,@RequestParam String passwd,Model model) {
//	boolean result = memberService.checkPw(userid, passwd);
//	if(result) {
//		memberService.deleteMember(userid);
//		return "redirect:/member/list.do";
//	}else {
//		model.addAttribute("dto", memberService.viewMember(userid));
//		model.addAttribute("message", "비밀번호가 일치하지 않습니다1");
//		return "member/view";
//	}
//	
//}
	
//	
//	@RequestMapping("member/list.do")//사용자가 요청하는 주소
//	public String memberList(Model model) {
//		List<MemberDTO> list = memberService.memberList();
//		logger.info("회원목록 : "+list);
//		model.addAttribute("list", list);
//		return "member/member_list1";
//	}
//	@RequestMapping("member/write.do")
//		public String write() {
//		return "member/write";
//	}
//	@RequestMapping("member/insert.do")
//	public String insert(MemberDTO dto) {
//		memberService.insertMember(dto);
//		return "redirect:/member/list.do";
//	}
//	@RequestMapping("member/view.do")
//	public String view(@RequestParam String userid,Model model) {
//		model.addAttribute("dto", memberService.viewMember(userid));
//		return "member/view";
//	}
//	
//	@RequestMapping("member/update.do")
//	public String update(@ModelAttribute MemberDTO dto,Model model) {
//		boolean result = memberService.checkPw(dto.getUserid(), dto.getPasswd());
//		logger.info("비밀번호확인:"+result);
//		
//		if(result) {
//			memberService.updateMember(dto);
//			return "redirect:/member/list.do";
//		}else {
//			MemberDTO dto2 = memberService.viewMember(dto.getUserid());
//			dto.setJoin_date(dto2.getJoin_date());
//			model.addAttribute("dto",dto);
//			model.addAttribute("message", "비밀번호가 불일치합니다");
//			return "member/view";
//		}
//		
//	}
//	
//	@RequestMapping("member/delete.do")
//	public String delete(@RequestParam String userid,@RequestParam String passwd,Model model) {
//		boolean result = memberService.checkPw(userid, passwd);
//		if(result) {
//			memberService.deleteMember(userid);
//			return "redirect:/member/list.do";
//		}else {
//			model.addAttribute("dto", memberService.viewMember(userid));
//			model.addAttribute("message", "비밀번호가 일치하지 않습니다1");
//			return "member/view";
//		}
//		
//	}
	
	
//}
