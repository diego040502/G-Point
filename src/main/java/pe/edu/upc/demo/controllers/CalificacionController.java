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

import pe.edu.upc.demo.entities.Calificacion;
import pe.edu.upc.demo.serviceinterface.ICalificacionService;

@Controller
@RequestMapping("/calificaciones")
public class CalificacionController {
	@Autowired
	private ICalificacionService calService;
	
	
	// REGISTRA UNA NUEVA CALIFICACION Y DIRECCIONA UN FORM DE REGISTRO
	@GetMapping("/nuevo")
	public String newCalificacion(Model model) {
		model.addAttribute("cal", new Calificacion());
		return "calificacion/frmCalificacion";
	}
	
	
	// GUARDA EL REGISTRO DE CALIFICACION Y DIRECCIONA A UN FORM DE GUARDADO
	@PostMapping ("/guardar")
	public String savePopularidad(@Valid Calificacion cal, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			return "calificacion/frmCalificacion";
		} else {
			calService.insert(cal);
			model.addAttribute("mensaje", "Se registró correctamente!!");
			return "redirect:/calificaciones/nuevo";
		}
	}

	
	// MUESTRA LAS PERSONAS REGISTRADAS EN UNA LISTA
	@GetMapping ("/listar")
	public String listCalificacion(Model model) {
		try {
			model.addAttribute("listaCalificaciones", calService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "calificacion/frmLista";
	}

	
	@RequestMapping ("/eliminar")
	public String deleteCalificacion(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				calService.delete(id); // elimina
				model.put("listaCalificaciones", calService.list()); // vuelve a listar actualizado
			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "calificacion/frmLista";
	}

	
	// ACTUALIZAR UN REGISTRO DE LA LISTA
	@RequestMapping ("/irmodificar/{id}")
	public String goUpdate(@PathVariable int id, Model model) {

		Optional<Calificacion> objCal = calService.listId(id); // Lista los atributos de un registro
		model.addAttribute("ca", objCal.get());// Trae los atributos del registro
		return "calificacion/frmActualiza";
	}

	
	@PostMapping ("/modificar")
	public String updateCalificacion(Calificacion ca) {
		calService.update(ca);
		return "redirect:/calificaciones/listar";
	}
}
