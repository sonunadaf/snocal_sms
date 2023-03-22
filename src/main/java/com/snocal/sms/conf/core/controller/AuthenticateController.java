package com.snocal.sms.conf.core.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.snocal.sms.conf.core.dto.AuthenticateDO;
import com.snocal.sms.module.constants.JspConstants;

@Controller
@RequestMapping("/auth")
public class AuthenticateController {
	Logger logger = LoggerFactory.getLogger(AuthenticateController.class);

	public AuthenticateController() {
		logger.info("AuthenticateController created");
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(AuthenticateDO authenticateDO) {
		logger.error("Request entered to login");
		return "redirect:/dashboard";

	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(AuthenticateDO authenticateDO) {
		return JspConstants.REGISTER;

	}
}
