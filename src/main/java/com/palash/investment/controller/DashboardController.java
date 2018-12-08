package com.palash.investment.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.palash.investment.util.ApplicationConstants;

@RequestMapping(value = "/users")
@Controller
public class DashboardController {

	@Autowired
	ApplicationConstants appConst;
	
	@GetMapping("/dashboard")
	public String dashboard(Model model, Principal userInfo) {
		model.addAttribute("userInfo",userInfo);
		model.addAttribute("pageTitle", this.appConst.APP_TITLE+ " | Dashboard");
		return "dashboard/dashboard";
	}
}
