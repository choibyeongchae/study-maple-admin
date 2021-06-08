package com.maple.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/member/*")
public class AuthController {

	//@GetMapping(value = "/login")
	@RequestMapping(value ="/member_login",method=RequestMethod.GET)
	public void loginPage(Model model) {
		
	}
}
