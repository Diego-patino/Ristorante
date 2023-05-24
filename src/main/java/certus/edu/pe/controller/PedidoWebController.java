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

import certus.edu.pe.modelo.Pedido;
import certus.edu.pe.servicios.PedidoServicio;

@Controller
@RequestMapping("/pedidos")
public class PedidoWebController {

	@Autowired
	private PedidoServicio servicio;
	
	@RequestMapping("/listarTodo")
	public String listarPedido(Model model) {
		List<Pedido> listaPedido = servicio.buscarTodo();
		
		System.out.println("LISTA DE pedidos : " + listaPedido);
		
		model.addAttribute("listaPedido", listaPedido);
		return "/moduloPedidos/listarTodo";
	}
	

	@RequestMapping("/nuevo")
	public String nuevoPedido(Model model) {
		Pedido pedido = new Pedido();
		model.addAttribute("pedidos", pedido);
		return "/moduloPedidos/nuevoPedido";
		
	}
	
	@RequestMapping(value = "/guardar" , method = RequestMethod.POST)
	public String crearPedido(@ModelAttribute("pedido") Pedido pedido) {
		    servicio.crear(pedido);
		    return "redirect:/pedidos/listarTodo";
	
	}
	
	@RequestMapping(value = "/actualizar/{id}")
	public ModelAndView editarPedido(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("/moduloPedidos/editarPedido");
	    Pedido pedido = servicio.buscarPorId(id);
	    mav.addObject("pedido", pedido);
	    return mav;
	}
	
	
	@RequestMapping(value ="/eliminar/{id}")
	public String eliminarPedido(@PathVariable(name = "id") int id) {
		  servicio.borrarPorId(id);
		 return "redirect:/pedidos/listarTodo";
		
	}
	
	
}

	