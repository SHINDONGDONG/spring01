package com.example.spring01.controller.shop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring01.model.shop.dto.CartDTO;
import com.example.spring01.service.shop.CartService;

@Controller
@RequestMapping("/shop/cart/*")
public class CartController {

	@Inject
	CartService cartService;
	
	@RequestMapping("insert.do")
	public String insert(@ModelAttribute CartDTO dto, HttpSession session) {
		String userid=(String)session.getAttribute("userid");
		if(userid==null) {
			return "redirect:/member/login.do";
		}
		dto.setUserid(userid);
		cartService.insert(dto);
		return "redirect:/shop/cart/list.do";
		
	}
	
	@RequestMapping("list.do")
	public ModelAndView list(HttpSession session,ModelAndView mav) {
		Map<String, Object> map = new HashMap<>();
		String userid=(String)session.getAttribute("userid");//로그인이 되어있는지 세션취득확인
		if(userid != null) {
			List<CartDTO> list = cartService.listCart(userid);//장바구니목록
			int sumMoney = cartService.sumMoney(userid); //금액 합계
			int fee=sumMoney >=30000 ? 0 : 2500; //배송료 계산 (합계금액이 3만원 이상이면 배송비를 0원으로 아니면 2500원부가)
			map.put("fee",fee);//배송료
			map.put("sum",sumMoney+fee);//총 합계
			map.put("list",list);//장바구니 목록
			map.put("count",list.size());//레코드 갯수
			mav.setViewName("shop/cart_list");
			mav.addObject("map", map);
			return mav;
		}else {
			return new ModelAndView("member/login","",null);
		}
	}
	
	@RequestMapping("delete.do")
	public String delete(@RequestParam int cart_id) {
		System.out.println("cart_id : "+ cart_id);
		cartService.delete(cart_id);
		return "redirect:/shop/cart/list.do";
	}
	
	@RequestMapping("deleteAll.do")
	public String deleteAll(HttpSession session) {
		String userid = (String) session.getAttribute("userid");
		if(userid != null) {
			cartService.deleteAll(userid);
			return "redirect:/shop/product/list.do";
		}else {
			return "redirect:/member/login.do";
		}
	}
	
	
	
}
