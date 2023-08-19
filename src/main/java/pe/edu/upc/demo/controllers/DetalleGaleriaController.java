package pe.edu.upc.demo.controllers;

import java.text.ParseException;
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

import pe.edu.upc.demo.entities.DetalleGaleria;
import pe.edu.upc.demo.serviceinterface.IDetalleGaleriaService;
import pe.edu.upc.demo.serviceinterface.IGaleriaService;
import pe.edu.upc.demo.serviceinterface.IJuegoService;
import pe.edu.upc.demo.serviceinterface.IUserService;


@Controller
@RequestMapping("/detallegalerias")
public class DetalleGaleriaController {
	
	@Autowired
	private IDetalleGaleriaService dgService;
	@Autowired
	private IGaleriaService gService;
	@Autowired
	private IUserService uService;
	@Autowired
	private IJuegoService jService;
	
	@GetMapping("/nuevo")
	public String newDetalleGaleria(Model model) {
		model.addAttribute("dg", new DetalleGaleria());
		model.addAttribute("listaGalerias", gService.list());
		model.addAttribute("listaUsuarios", uService.listar());
		model.addAttribute("listaJuegos", jService.list());
		return "detallegaleria/detallegaleria";
	}
	
	@PostMapping("/guardar")
	public String registrarDetalleGaleria(@Valid DetalleGaleria objDg, BindingResult binRes, Model model) throws ParseException {
		if (binRes.hasErrors()) {
			return "detallegaleria/detallegaleria";
		} else {
			dgService.insert(objDg);
			model.addAttribute("mensaje", "Se guardó correctamente");
			return "redirect:/detallegalerias/listar";
		}
	}
	
	@GetMapping("/listar")
	public String listarDetalleGalerias(Model model) {
		try {
			model.addAttribute("dg", new DetalleGaleria());
			model.addAttribute("listadetallegaleria", dgService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/detallegaleria/listaDetalleGaleria";
	}
	

	@RequestMapping("/eliminar")
	public String deleteDetalleGaleria(Map<String, Object> model, @RequestParam(value = "id") Integer id) {

		try {

			if (id != null && id > 0) {
				dgService.delete(id); 
				model.put("listaDetalleGaleria", dgService.list());
			}

		} catch (Exception e) {
			model.put("error", e.getMessage());
		}

		return "redirect:/detallegalerias/listar";
	}
	
	
	
	@RequestMapping("/irmodificar/{id}")
	public String goUpdate(@PathVariable int id, Model model) {
		
		Optional<DetalleGaleria>objDg= dgService.listId(id);
		model.addAttribute("dga", objDg.get());
		
		
		return "detallegaleria/ActualizarDetalleGaleria";
	}
	
	
	@RequestMapping("/modificar")
	public String updatedetallegaleria(DetalleGaleria dga) {
		dgService.update(dga);
		return "redirect:/detallegalerias/listar";
	}
	
	
}
