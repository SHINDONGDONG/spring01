package com.example.spring01.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring01.model.dto.ProductDTO;

@Controller
public class MainController {

	private static final Logger logger = 
			LoggerFactory.getLogger(MainController.class);
/*	
@RequestMapping("/")
public String main(Model model) {
	logger.info("성공적~");
	model.addAttribute("message", "홈페이지에 오신것을 환영합니다");
	return "main";
}
*/
@RequestMapping("/")
public String main(Model model) {
	logger.info("성공!");
	model.addAttribute("message", "홈페이지2에 오신걸환영한다");
	return "main";
}

//
////@RequestMapping("gugu.do")
//public String gugu(int dan,Model model) {
//	String result = "";
//	for(int i=1; i<=9; i++) {
//		result += dan+"x"+i+"="+dan*i+"<br>";
//	}
//	model.addAttribute("result", result);
//	return "test/gugu";
//}
//
//@RequestMapping("test")
//public void test() {}
//
//@RequestMapping("test/doA.do")
//public String doA(Model model) {
//	logger.info("colled doA....");
//	model.addAttribute("doA", "doA로 호출된 doB입니다");
//	return "test/doB";
//}
//@RequestMapping("test/doB.do")
//public String doB(Model model) {
//	logger.info("colled doB....");
//	return "test/doB";
//}
//
//@RequestMapping("test/doC.do")
//public ModelAndView doC() {
//	Map<String,Object> map = new HashMap<>();
//	map.put("product", new ProductDTO("샤프심",10000));
//	return new ModelAndView("test/doC","map",map);
//}
//


}
