package com.example.spring01.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring01.model.dto.ProductDTO;

@RestController
public class SampleRestController {
	private static final Logger logger = 
			LoggerFactory.getLogger(SampleRestController.class);
	//@RestBody
	@RequestMapping("test/doF")
	public ProductDTO doF() {
		//호출한곳으로 데이터가 넘어감 json
		return new ProductDTO("냉장고",5000000);
	}

}
