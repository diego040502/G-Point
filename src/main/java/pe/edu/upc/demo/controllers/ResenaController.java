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

import pe.edu.upc.demo.entities.Resena;

import pe.edu.upc.demo.serviceinterface.IResenaService;


@Controller
@RequestMapping("/resenas")
public class ResenaController {
	@Autowired
	private IResenaService reService;
	
	@GetMapping("/nuevo")
	public String newResena(Model model) {
		model.addAttribute("re",new Resena());
		return "resena/frmRegistro";
	}
	
	@PostMapping("/guardar")
	public String saveResena(@Valid Resena re, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			return "resena/frmRegistro";
		} else {
			reService.insert(re);
			model.addAttribute("mensaje","Se registró correctamente");
			return "redirect:/resenas/nuevo";
		}
				
	}
	
	@GetMapping("/listar")
	public String listResena(Model model) {
		try {
			model.addAttribute("listaResenas", reService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/resena/frmLista";
	}
	
	@RequestMapping("/eliminar")
	public String deleteResena(Map<String,Object> model, @RequestParam(value="id")Integer id) {
		try {
			if(id != null && id>0) {
				reService.delete(id);
				model.put("listaResenas", reService.list());
			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "resena/frmLista";
	}
	
	@RequestMapping("/irmodificar/{id}")
	public String goUpdate(@PathVariable int id, Model model) {
		
		Optional<Resena>objRe= reService.listId(id);
		model.addAttribute("res", objRe.get());
		return "resena/frmActualiza";
	}
	
	@PostMapping("/modificar")
	public String updateResena(Resena re) {
		reService.update(re);
		return "redirect:/resenas/listar";
	}
	
	
}
