package br.com.alura.leilao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	
	/** 
	 * @param model
	 * @return String
	 */
	@GetMapping("/")
	public String index(Model model) {
		return "redirect:/leiloes";
	}

}
