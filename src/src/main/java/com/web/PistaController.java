package com.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.service.PistaService;

@Controller
public class PistaController {

	private PistaService pistaservice;
	
	@GetMapping("/futbol")
	public String futbol(Model model) {
			
		model.addAttribute("pistasFutbol", pistaservice.pistasTipo("Futbol".toLowerCase()));
		
		return "futbol";
	}
	
	@GetMapping("/baloncesto")
	public String baloncesto(Model model) {
		
		model.addAttribute("pistasBaloncesto", pistaservice.pistasTipo("baloncesto".toLowerCase()));
		
		return "baloncesto";
	}
	
	@GetMapping("/padel")
	public String padel(Model model) {
		
		model.addAttribute("pistasPadel", pistaservice.pistasTipo("padel".toLowerCase()));
		
		return "padel";
	}
	
	@GetMapping("/tenis")
	public String tenis(Model model) {
		
		model.addAttribute("pistasTenis", pistaservice.pistasTipo("Tenis".toLowerCase()));
		
		return "tenis";
	}

	public PistaController(PistaService pistaservice) {
		super();
		this.pistaservice = pistaservice;
	}
	
	
}
