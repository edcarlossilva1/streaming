package com.techchallenge.streaming.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * Criando a classe controller Home para chamada da página html
 */
@Controller
public class HomeController {
	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home/index");
		mv.addObject("msg","Mensagem vinda diretamente da classe controller");
		return mv;
	}
}
