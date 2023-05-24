package certus.edu.pe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import certus.edu.pe.modelo.Usuario;
import certus.edu.pe.servicios.UsuarioServicio;

@Controller
@RequestMapping("/usuario")
public class UsuarioWebController {

	@Autowired
	private UsuarioServicio servicio;
	
	@RequestMapping("/listarTodo")
	public String listaUsuario(Model model) {
		List<Usuario> listaUsuario = servicio.buscarTodo();
		System.out.println("LISTA DE Usuarios : " + listaUsuario);
		
		model.addAttribute("listaUsuario", listaUsuario);
		return "/moduloUsuarios/listarTodo";
	}
	

	@RequestMapping("/nuevo")
	public String nuevoUsuario(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		return "/moduloUsuarios/nuevoUsuario";
		
	}
	
	@RequestMapping(value = "/guardar" , method = RequestMethod.POST)
	public String crearUsuario(@ModelAttribute("usuario") Usuario usuario) {
			servicio.crear(usuario);
		    return "redirect:/usuario/listarTodo";
	
	}
	
	@RequestMapping(value = "/actualizar/{id}")
	public ModelAndView editarUsuario(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("/moduloUsuarios/editarUsuario");
	    Usuario usuario = servicio.buscarPorId(id);
	    mav.addObject("usuario", usuario);
	    return mav;
	}
	
	
	@RequestMapping(value ="/eliminar/{id}")
	public String eliminarUsuario(@PathVariable(name = "id") int id) {
		servicio.borrarPorId(id);
		 return "redirect:/usuario/listarTodo";
		
	}
}
