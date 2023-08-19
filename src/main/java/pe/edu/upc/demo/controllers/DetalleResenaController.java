package pe.edu.upc.demo.controllers;

import java.text.ParseException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.demo.entities.DetalleResena;

import pe.edu.upc.demo.serviceinterface.IDetalleResenaService;
import pe.edu.upc.demo.serviceinterface.IJuegoService;
import pe.edu.upc.demo.serviceinterface.IResenaService;
import pe.edu.upc.demo.serviceinterface.IUserService;


@Controller
@RequestMapping("/detalleresenas")
public class DetalleResenaController {
	
	@Autowired
	private IDetalleResenaService drService;
	@Autowired
	private IUserService uService;
	@Autowired
	private IJuegoService jService;
	@Autowired
	private IResenaService rService;
	
	@GetMapping("/nuevo")
	public String newDetalleResena(Model model) {
		model.addAttribute("dr", new DetalleResena());
		model.addAttribute("listaResenas", rService.list());
		model.addAttribute("listaUsuarios", uService.listar());
		model.addAttribute("listaJuegos", jService.list());
		return "detalleresena/detalleresena";
	}
	
	@PostMapping("/guardar")
	public String registrarDetalleResena(@Valid DetalleResena objDr, BindingResult binRes, Model model) throws ParseException {
		if (binRes.hasErrors()) {
			return "detalleresena/detalleresena";
		} else {
			drService.insert(objDr);
			model.addAttribute("mensaje", "Se guardó correctamente");
			return "redirect:/detalleresenas/listar";
		}
	}
	
	@GetMapping("/listar")
	public String listarDetalleResenas(Model model) {
		try {
			model.addAttribute("dr", new DetalleResena());
			model.addAttribute("listaDetalleResenas", drService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/detalleresena/listaDetalleResena";
	}
}
