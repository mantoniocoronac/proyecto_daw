package com.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.Pista;
import com.model.Reserva;
import com.model.User;
import com.service.PistaService;
import com.service.ReservaService;
import com.service.UserService;

@Controller
public class ReservaController {

	@Autowired
	private ReservaService reservaService;
	
	@Autowired
	private PistaService pistaservice;

	@Autowired
	private UserService userService;
	
	@GetMapping("/listaReservas")
	public String gestionReservas(Model model) {

			model.addAttribute("reservas", reservaService.findAll());

			return "listaReservas";
		}
	
	@GetMapping("/listaUsers")
	public String gestionUsers(Model model) {

			model.addAttribute("user", reservaService.ufindAll());

			return "listaUsers";
		}
	
	@GetMapping("/listaReservasUser")
	public String gestionReservasUser(Model model) {

			model.addAttribute("reservas", reservaService.findAll());

			return "listaReservasUser";
		}

		@GetMapping("/add/{id}")
		public String muestraFormulario(@PathVariable("id") Long Pistaid, Model model) {

			Optional<User> user = userService.findById((long) 1);
			
			model.addAttribute("pistas", pistaservice.findById(Pistaid));
			model.addAttribute("user",   user.get());
			model.addAttribute("reserva", new Reserva());
			
			return "formulario";
		}

		@GetMapping("/detalles/{id}")
		public String detalles(@PathVariable("id") Long Pistaid, Model model) {

			model.addAttribute("pista", pistaservice.findById(Pistaid));
			//model.addAttribute("user",userService.findById(Pistaid));
			model.addAttribute("reservasPista", pistaservice.findById(Pistaid).getReservas());

			return "detalles";
		}

		@PostMapping({ "/add/addReserva", "/editar/addReserva" })
		public String procesaFormulario(@ModelAttribute("reserva") Reserva reserva) {

			reservaService.save(reserva);  

			return "redirect:/listaReservas";
		}

		@GetMapping("/editar/{id}")
		public String editarCita(@PathVariable("id") Long Reservaid, Model model) {
			Reserva reserva = reservaService.findById(Reservaid);
			
			Optional<User> user = userService.findById((long) 1);
			
			
			if (reserva != null) {
				Pista t = reserva.getPista();
				reserva.setId(Reservaid);

				model.addAttribute("reserva", reserva);
				model.addAttribute("pistas", t);
				model.addAttribute("user", user.get());
				return "formulario";
			} else {
				return "redirect:/listaReservas";
			}
		}

		@GetMapping("/borrar/{id}")
		public String borrarCita(@PathVariable("id") Long id) {

			Reserva reserva = reservaService.findById(id);

			if (reserva != null) {
				reservaService.delete(reserva);
			} else {
				return "redirect:/listaReservas/?error=true";
			}

			return "redirect:/listaReservas";
		}
		
		@GetMapping("/borrarUser/{id}")
		public String borrarUser(@PathVariable("id") Long id) {

			reservaService.eliminar(id);

			return "redirect:/listaUsers";
		}
		
	}
	
