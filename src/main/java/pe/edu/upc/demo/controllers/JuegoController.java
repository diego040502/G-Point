package pe.edu.upc.demo.controllers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.edu.upc.demo.entities.Juego;

import pe.edu.upc.demo.serviceinterface.ICalificacionService;
import pe.edu.upc.demo.serviceinterface.ICategoriaService;
import pe.edu.upc.demo.serviceinterface.IClasificacionService;
import pe.edu.upc.demo.serviceinterface.IJuegoService;
import pe.edu.upc.demo.serviceinterface.IPopularidadService;
import pe.edu.upc.demo.serviceinterface.IUploadFileService;



@Controller
@RequestMapping("/juegos")
public class JuegoController {
	
	@Autowired
	private IJuegoService jService;
	@Autowired
	private ICategoriaService cService;
	@Autowired
	private IClasificacionService claService;
	@Autowired
	private ICalificacionService caService;
	@Autowired
	private IPopularidadService poService;
	@Autowired
	private IUploadFileService uploadFileService;
	
	@GetMapping(value = "/uploads/{filename:.+}")
	public ResponseEntity<Resource> verFoto(@PathVariable String filename) {

		Resource recurso = null;

		try {
			recurso = uploadFileService.load(filename);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"")
				.body(recurso);
	}
	
	@GetMapping("/nuevo")
	public String newJuego(Model model) {
		model.addAttribute("j", new Juego());
		model.addAttribute("listaCategorias", cService.list());
		model.addAttribute("listaClasificaciones", claService.list());
		model.addAttribute("listaCalificaciones", caService.list());
		model.addAttribute("listaPopularidades", poService.list());
		return "juego/juego";
	}
	

	
	@PostMapping("/guardar")
	public String registrarJuego(@Valid @ModelAttribute("j") Juego j, BindingResult result, Model model,
			@RequestParam("file") MultipartFile foto, RedirectAttributes flash, SessionStatus status) throws Exception {
		if (result.hasErrors()) {
			System.out.println(result.getFieldError(null));
			return "juego/juego";
		} else {
			if (!foto.isEmpty()) {

				if (j.getIdJuego() > 0 && j.getFoto() != null && j.getFoto().length() > 0) {

					uploadFileService.delete(j.getFoto());
				}

				String uniqueFilename = null;
				try {
					uniqueFilename = uploadFileService.copy(foto);
				} catch (IOException e) {
					e.printStackTrace();
				}

				flash.addFlashAttribute("info", "Has subido correctamente '" + uniqueFilename + "'");
				j.setFoto(uniqueFilename);
			}
			int rpta = jService.insert(j);
			if (rpta > 0) {
				model.addAttribute("mensaje", "Ya existe");
				return "/juego/juego";
			} else {
				model.addAttribute("mensaje", "Se guardó correctamente");
				status.setComplete();
			}
		}
		

		return "redirect:/juegos/listar";
	}
	
	
	@GetMapping("/listar")
	public String listarJuegos(Model model) {
		try {	
			model.addAttribute("j", new Juego());
			model.addAttribute("listaJuegos", jService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/juego/listaJuego";
	}
	
	@GetMapping(value = "/ver/{id}")
	public String ver(@PathVariable(value = "id") Integer id, Map<String, Object> model, RedirectAttributes flash) {

		Optional<Juego> juego = jService.listarId(id);
		if (juego == null) {
			flash.addFlashAttribute("error", "El Producto no existe en la base de datos");
			return "redirect:/juegos/listar";
		}

		model.put("j", juego.get());

		return "juego/ver";
	}
	
	@RequestMapping("/reporte1")
	public String resenaJuego(Map <String, Object> model) {
		model.put("reporteLista", jService.resenaJuego());
		return "juego/vista";
	}
	
	
}
