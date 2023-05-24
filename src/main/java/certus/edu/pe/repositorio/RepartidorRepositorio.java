package certus.edu.pe.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import certus.edu.pe.modelo.Repartidor;

public interface  RepartidorRepositorio extends CrudRepository<Repartidor, Integer> {

	@Query(value = "SELECT a FROM Repartidor a WHERE a.id_repartidor =?1")
	public List<Repartidor> buscarRepartidorporNombre(String repartidor);
	
	
	
}
