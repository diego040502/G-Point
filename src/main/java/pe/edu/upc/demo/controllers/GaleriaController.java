package pe.edu.upc.demo.controllers;

import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.edu.upc.demo.entities.Galeria;
import pe.edu.upc.demo.serviceinterface.IGaleriaService;

@Controller
@RequestMapping("/galerias")
public class GaleriaController {

	@Autowired
	private IGaleriaService galService;

	@GetMapping("/nuevo")
	public String newGaleria(Model model) {

		model.addAttribute("g", new Galeria());
		return "galeria/frmRegistro";
	}

	@PostMapping("/guardar")
	public String saveGaleria(@Valid Galeria gal, BindingResult bindRes, Model model) {

		if (bindRes.hasErrors()) {
			return "galerias/frmRegistro";

		} else {
			galService.inset(gal);
			model.addAttribute("mensaje", "se registro correctametne !!");
			return "redirect:/galerias/nuevo";
		}
	}

	@GetMapping("/listar")
	public String lisGaleria(Model model) {
		try {

			model.addAttribute("listaGaleria", galService.list());

		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}

		return "/galeria/frmLista";
	}

	
	
	@RequestMapping("/eliminar")
	public String deleteGaleria(Map<String, Object> model, @RequestParam(value = "id") Integer id) {

		try {

			if (id != null && id > 0) {
				galService.delete(id); 
				model.put("listaGaleria", galService.list());
			}

		} catch (Exception e) {
			model.put("error", e.getMessage());
		}

		return "galeria/frmLista";
	}
	
	
	
	@RequestMapping("/irmodificar/{id}")
	public String goUpdate(@PathVariable int id, Model model) {
		
		Optional<Galeria>objGal= galService.listId(id);
		model.addAttribute("gal", objGal.get());
		
		
		return "galeria/frmActualizar";
	}
	
	
	@RequestMapping("/modificar")
	public String updatePerson(Galeria ga) {
		galService.update(ga);
		return "redirect:/galerias/listar";
	}
	
	
	
	
	
	

}
