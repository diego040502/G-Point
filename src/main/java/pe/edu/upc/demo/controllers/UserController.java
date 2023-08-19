package pe.edu.upc.demo.controllers;

import java.text.ParseException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.demo.entities.Users;
import pe.edu.upc.demo.serviceinterface.IUserService;


@Controller
@RequestMapping("/usuarios")
public class UserController {

	@Autowired
	private IUserService uService;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/nuevo")
	public String newUser(Model model) {
		model.addAttribute("u", new Users());
		return "user/usuario";
	}

	@PostMapping("/guardar")
	public String registrarUser(@Valid Users objTel, BindingResult binRes, Model model) throws ParseException {
		if (binRes.hasErrors()) {
			return "user/usuario";
		} else {
			String p = objTel.getPassword();
			String pE = passwordEncoder.encode(p);
			Users us = new Users();
			us.setUsername(objTel.getUsername());
			us.setEnabled(objTel.getEnabled());
			us.setPassword(pE);

			us.setNombre(objTel.getNombre());
			us.setApellido(objTel.getApellido());
			us.setFechaRegistro(objTel.getFechaRegistro());
			
			uService.insertar(us);
			model.addAttribute("mensaje", "Se guardó correctamente");
			// status.setComplete();
			return "redirect:/usuarios/listar";
		}
	}

	@GetMapping("/listar")
	public String listarUsuarios(Model model) {
		try {
			model.addAttribute("listaUsuarios", uService.listar());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/user/listaUsuario";
	}

}
