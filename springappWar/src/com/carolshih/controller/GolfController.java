package com.carolshih.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/golf")
public class GolfController {
	
	@RequestMapping()
	public ModelAndView showHendler(){
		ModelAndView mav = new ModelAndView("gMap");

		return mav;
	}
	

}
