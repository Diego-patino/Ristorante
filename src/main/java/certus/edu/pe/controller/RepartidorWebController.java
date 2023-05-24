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

import certus.edu.pe.modelo.Repartidor;
import certus.edu.pe.servicios.RepartidorServicio;

@Controller
@RequestMapping("/repartidores")
public class RepartidorWebController {

	@Autowired
	private RepartidorServicio servicio;
	
	@RequestMapping("/listarTodo")
	public String listarRepartidor(Model model) {
		List<Repartidor> listaRepartidor = servicio.buscarTodo();
		
		System.out.println("LISTA DE repartidores : " + listaRepartidor);
		
		model.addAttribute("listaRepartidor", listaRepartidor);
		return "/moduloRepartidores/listarTodo";
	}
	

	@RequestMapping("/nuevo")
	public String nuevoRepartidor(Model model) {
		Repartidor repartidor = new Repartidor();
		model.addAttribute("repartidor", repartidor);
		return "/moduloRepartidores/nuevoRepartidor";
		
	}
	
	@RequestMapping(value = "/guardar" , method = RequestMethod.POST)
	public String crearRepartidor(@ModelAttribute("repartidor") Repartidor repartidor) {
		    servicio.crear(repartidor);
		    return "redirect:/repartidores/listarTodo";
	
	}
	
	@RequestMapping(value = "/actualizar/{id}")
	public ModelAndView editarRepartidor(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("/moduloRepartidores/editarRepartidor");
	    Repartidor repartidor = servicio.buscarPorId(id);
	    mav.addObject("repartidor", repartidor);
	    return mav;
	}
	
	
	@RequestMapping(value ="/eliminar/{id}")
	public String eliminarRepartidor(@PathVariable(name = "id") int id) {
		  servicio.borrarPorId(id);
		 return "redirect:/repartidores/listarTodo";
		
	}
}
