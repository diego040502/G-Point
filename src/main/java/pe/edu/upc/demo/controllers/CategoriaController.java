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

import pe.edu.upc.demo.entities.Categoria;
import pe.edu.upc.demo.serviceinterface.ICategoriaService;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {
	@Autowired
	private ICategoriaService catService;
	
	@GetMapping("/nuevo")
	public String newCategory(Model model) {
		model.addAttribute("c", new Categoria());
		return "categoria/frmRegistro";
	}
	
	@PostMapping("/guardar")
	public String saveCategory(@Valid Categoria cat, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			return "categoria/frmRegistro"; // carpeta
		} else {
			catService.insert(cat);
			model.addAttribute("mensaje", "Se registró correctamente!!");
			return "redirect:/categorias/listar";// @RequestMapping
		}
	}
	@GetMapping("/listar")
	public String listPerson(Model model) {
		try {
			model.addAttribute("listaCategorias", catService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/categoria/frmLista"; // carpeta
	}
	
	@RequestMapping("/eliminar")
	public String deleteCategoory(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				catService.delete(id);
				model.put("listaCategorias", catService.list());
			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "categoria/frmLista"; // carpeta
	}
	
	@RequestMapping("/irmodificar/{id}")
	public String goUpdate(@PathVariable int id, Model model) {
		Optional<Categoria> objPer = catService.listId(id);
		model.addAttribute("cate", objPer.get());
		return "categoria/frmActualiza"; // carpeta
	}

	@PostMapping("/modificar")
	public String updateCategory(Categoria ca) {
		catService.update(ca);
		//model.addAttribute("mensaje", "Se modificó correctamente!!");
		return "redirect:/categorias/listar";// @RequestMapping
	}
}
