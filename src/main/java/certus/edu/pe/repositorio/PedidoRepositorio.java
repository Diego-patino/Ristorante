package certus.edu.pe.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import certus.edu.pe.modelo.Pedido;


public interface PedidoRepositorio extends CrudRepository<Pedido, Integer> {

	@Query(value = "SELECT a FROM Pedido a WHERE a.id_pedido =?1")
	public List<Pedido> buscarPedidoPorUsuario(Integer pedido);
	
	
	@Query(value = "SELECT a FROM Pedido a WHERE a.id_pedido like CONCAT(?1, '%')")
	public List<Pedido> buscarPedidoLikeUsuario(Integer pedido);
	
}
