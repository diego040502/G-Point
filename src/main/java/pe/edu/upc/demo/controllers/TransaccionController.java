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

import pe.edu.upc.demo.entities.Transaccion;
import pe.edu.upc.demo.serviceinterface.IJuegoService;
import pe.edu.upc.demo.serviceinterface.ITransaccionService;
import pe.edu.upc.demo.serviceinterface.IUserService;

@Controller
@RequestMapping("/transacciones")
public class TransaccionController {
	@Autowired
	private ITransaccionService traService;
	
	@Autowired
	private IUserService uService;
	
	@Autowired
	private IJuegoService jService;
	
	
	// REGISTRA UNA NUEVA CALIFICACION Y DIRECCIONA UN FORM DE REGISTRO
	@GetMapping("/nuevo")
	public String newTransaccion(Model model) {
		model.addAttribute("tra", new Transaccion());
		model.addAttribute("listaUsuarios", uService.listar());
		model.addAttribute("listaJuegos", jService.list());
		return "transaccion/frmTransaccion";
	}
	
	
	// GUARDA EL REGISTRO DE CALIFICACION Y DIRECCIONA A UN FORM DE GUARDADO
	@PostMapping ("/guardar")
	public String saveTransaccion(@Valid Transaccion tra, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			return "transaccion/frmTransaccion";
		} else {
			traService.insert(tra);
			model.addAttribute("mensaje", "Se registró correctamente!!");
			return "redirect:/transacciones/listar";
		}
	}

	
	// MUESTRA LAS PERSONAS REGISTRADAS EN UNA LISTA
	@GetMapping ("/listar")
	public String listTransaccion(Model model) {
		try {
			model.addAttribute("listaTransacciones", traService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/transaccion/frmLista";
	}

	
	@RequestMapping ("/eliminar")
	public String deleteTransaccion(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				traService.delete(id); // elimina
				model.put("listaTransacciones", traService.list()); // vuelve a listar actualizado
			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "redirect:/transaccion/frmLista";
	}

	
	// ACTUALIZAR UN REGISTRO DE LA LISTA
	@RequestMapping ("/irmodificar/{id}")
	public String goUpdate(@PathVariable int id, Model model) {

		Optional<Transaccion> objTra = traService.listId(id); // Lista los atributos de un registro
		model.addAttribute("tra", objTra.get());// Trae los atributos del registro
		return "transaccion/frmActualiza";
	}

	
	@PostMapping ("/modificar")
	public String updateTransaccion(Transaccion tr) {
		traService.update(tr);
		return "redirect:/transaccion/listar";
	}
}
