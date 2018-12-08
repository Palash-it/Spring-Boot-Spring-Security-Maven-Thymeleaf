package com.palash.investment.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.palash.investment.util.ApplicationConstants;

@Controller
public class ErrorHandleController implements ErrorController{

	@Autowired
	ApplicationConstants appConst;
	
	@RequestMapping(value = "/error")
	public String handleError(HttpServletRequest request,Model model) {
		String viewPage = "error/error";
		model.addAttribute("pageTitle", this.appConst.APP_TITLE+ " | ERROR");
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		if(status != null) {
			try {
				Integer statusCode = Integer.valueOf(status.toString());
				if(statusCode == HttpStatus.NOT_FOUND.value()) {
					viewPage = "error/error-page-404";
				}else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
					viewPage = "error/error-page-500";
				}
			}catch (ClassCastException e) {
				
			}
		}
		return viewPage;
	}
	@Override
	public String getErrorPath() {
		return "error";
	}

}
