package com.palash.investment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.palash.investment.util.ApplicationConstants;

@RequestMapping(value = "auth")
@Controller
public class AuthenticationController {

	@Autowired
	ApplicationConstants appConst;
	
	@GetMapping(value = {"/login**","/"})
	public String login(Model model) {
		model.addAttribute("pageTitle", this.appConst.APP_TITLE+ " | Login"); 
		return "authentication/login";
	}
	
	
}
