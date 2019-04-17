package com.xinlianshiye.shoestp.consult.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.xinlianshiye.shoestp.user.api.entity.Purchase;

@ControllerAdvice(basePackages = "com.xinlianshiye.shoestp.consult.controller")
public class AuthControllerAdvice {
	
	@ModelAttribute
	  public void addAttributes(Model model, @RequestHeader String token)
	      throws JsonProcessingException {
		Purchase purchase = new Purchase();
		purchase.setPkey(1);
		model.addAttribute("login", purchase);
	  }
}
