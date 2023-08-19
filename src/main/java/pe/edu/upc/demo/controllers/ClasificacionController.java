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

import pe.edu.upc.demo.entities.Clasificacion;

import pe.edu.upc.demo.serviceinterface.IClasificacionService;

@Controller
@RequestMapping("/clasificaciones")
public class ClasificacionController {
	
	
	@Autowired
	private IClasificacionService claService;
	
	@GetMapping("/nuevo")
	public String newClasificacion(Model model) {
		model.addAttribute("cl", new Clasificacion());
		return "clasificacion/frmRegistro";
	}
	
	@PostMapping("/guardar")
	public String saveClasificacion(@Valid Clasificacion cat, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			return "clasificacion/frmRegistro"; 
		} else {
			claService.insert(cat);
			model.addAttribute("mensaje", "Se registró correctamente!!");
			return "redirect:/clasificaciones/listar";
		}
	}
	
	@GetMapping("/listar")
	public String lisGaleria(Model model) {
		try {

			model.addAttribute("listaClasificaciones", claService.list());

		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}

		return "/clasificacion/frmLista";
	}
	
	@RequestMapping("/eliminar")
	public String deleteClasificacion(Map<String,Object> model, @RequestParam(value="id")Integer id) {
		try {
			if(id != null && id>0) {
				claService.delete(id);
				model.put("listaClasificaciones", claService.list());
			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "clasificacion/frmLista";
	}
	
	@RequestMapping("/irmodificar/{id}")
	public String goUpdate(@PathVariable int id, Model model) {
		
		Optional<Clasificacion>objCla= claService.listId(id);
		model.addAttribute("cla", objCla.get());
		return "clasificacion/frmActualizar";
	}
	
	@PostMapping("/modificar")
	public String updateClasificacion(Clasificacion clas) {
		claService.update(clas);
		return "redirect:/clasificaciones/listar";
	}
	
	
}
