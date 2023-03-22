package com.snocal.sms.conf.core.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.snocal.sms.module.constants.JspConstants;

@Controller
public class HomeController {

	Logger logger = LoggerFactory.getLogger(HomeController.class);

	public HomeController() {
		logger.info("Logger instiate from Constructor");
	}

	@RequestMapping(value = "/")
	public String index() {
		return JspConstants.INDEX;
	}

	@RequestMapping(value = "/dashboard")
	public String dashboard() {
		logger.error("Request entered to dashboard");
		return JspConstants.DASHBOARD;

	}

}
