package com.maple.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/*")
public class AuthController {

	@GetMapping(value ="/member_login")
	public void loginPage(Model model) {
		
	}
}
