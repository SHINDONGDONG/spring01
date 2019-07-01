package com.example.spring01.controller.shop;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring01.model.dto.MemberDTO;
import com.example.spring01.model.shop.dto.ProductDTO1;
import com.example.spring01.service.shop.ProductService;

@Controller
@RequestMapping("/shop/product/*") // 공통적인 url mapping
public class ProductController {

	@Autowired // 의존관계 주입
	ProductService productService; // 스프링에서 만든 서비스를 객체화시켜 연결시킴

	@RequestMapping("list.do") // 세부적인 url mapping
	public ModelAndView list(ModelAndView mav) {
		mav.setViewName("/shop/product_list"); // 이동할 페이지
		mav.addObject("list", productService.listProduct());
		return mav;
	}

	@RequestMapping("/detail/{product_id}")
		public ModelAndView detail(@PathVariable("product_id") int product_id, ModelAndView mav) {
		mav.setViewName("/shop/product_detail");
		mav.addObject("dto",productService.detailProduct(product_id));
		return mav;
	}

}
