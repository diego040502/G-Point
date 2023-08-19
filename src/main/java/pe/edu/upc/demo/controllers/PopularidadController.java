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

import pe.edu.upc.demo.entities.Popularidad;
import pe.edu.upc.demo.serviceinterface.IPopularidadService;

@Controller
@RequestMapping ("/popularidades")
public class PopularidadController {
	@Autowired
	private IPopularidadService popService;
	
	
	//REGISTRA UNA NUEVA PERSONA Y DIRECCIONA UN FORM DE REGISTRO
	@GetMapping ("/nuevo")
	public String newPopularidad(Model model) {
		model.addAttribute("pop", new Popularidad());
		return "popularidad/frmPopularidad";
	}
	
	
	//GUARDA EL REGISTRO DE PERSONA Y DIRECCIONA A UN FORM DE GUARDADO
	@PostMapping ("/guardar")
	public String savePopularidad(@Valid Popularidad pop, BindingResult binRes, Model model) {
		if(binRes.hasErrors()) {
			return "popularidad/frmPopularidad";
		}else {
			popService.insert(pop);
			model.addAttribute("mensaje", "Se registró correctamente!!");
			return "redirect:/popularidades/nuevo";
		}
	}
	
	
	//MUESTRA LAS PERSONAS REGISTRADAS EN UNA LISTA
	@GetMapping ("/listar")
	public String listPopularidad(Model model) {
		try {
			model.addAttribute("listaPopularidades", popService.list());
		} catch(Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/popularidad/frmLista";
	}
	
	
	@RequestMapping ("/eliminar")
	public String deletePopularidad(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				popService.delete(id); // elimina
				model.put("listaPopularidades", popService.list()); // vuelve a listar actualizado
			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "popularidad/frmLista";
	}

	
	// ACTUALIZAR UN REGISTRO DE LA LISTA
	@RequestMapping ("/irmodificar/{id}")
	public String goUpdate(@PathVariable int id, Model model) {

		Optional<Popularidad> objPop = popService.listId(id); // Lista los atributos de un registro
		model.addAttribute("popu", objPop.get()); // Trae los atributos del registro
		return "popularidad/frmActualiza";
	}

	
	@PostMapping("/modificar")
	public String updatePopularidad(Popularidad po) {
		popService.update(po);
		return "redirect:/popularidades/listar";
	}
}
