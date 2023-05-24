package certus.edu.pe.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import certus.edu.pe.modelo.Pedido;
import certus.edu.pe.repositorio.PedidoRepositorio;
import javax.transaction.Transactional;

@Service
@Transactional
public class PedidoServicio {
	
	@Autowired // Inyección de dependencia
	private PedidoRepositorio repositorio;
	
	
	public List<Pedido> buscarTodo(){
		return (List<Pedido>) repositorio.findAll();
	}

	public Pedido crear(Pedido pedido) {
		return repositorio.save(pedido);
		
	}
	
	public Pedido actualizar(Pedido pedidoActualizar) {
		
		// primero realizamos la búsqueda de películas
		Pedido pedidoActual = repositorio.findById(pedidoActualizar.getId_pedido()).get();
		
		pedidoActual.setId_pedido(pedidoActualizar.getId_pedido());
		pedidoActual.setUsuario(pedidoActualizar.getUsuario());
		pedidoActual.setRepartidor(pedidoActualizar.getRepartidor());
		pedidoActual.setDireccion(pedidoActualizar.getDireccion());
		pedidoActual.setFecha_hora(pedidoActualizar.getFecha_hora());
		
		Pedido pedidoActualizado = repositorio.save(pedidoActual);
		return pedidoActualizado;
	}
	
	public Pedido buscarPorId(Integer id) {
		
		return repositorio.findById(id).get();
		
	}
	
	public void borrarPorId(Integer id) {
		
		repositorio.deleteById(id);
	}
	
	
}
