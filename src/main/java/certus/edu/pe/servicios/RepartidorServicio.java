package certus.edu.pe.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import certus.edu.pe.modelo.Repartidor;
import certus.edu.pe.repositorio.RepartidorRepositorio;
import javax.transaction.Transactional;

@Service
@Transactional
public class RepartidorServicio {

	@Autowired // Inyección de dependencia
	private RepartidorRepositorio repositorio;
	
	
	public List<Repartidor> buscarTodo(){
		return (List<Repartidor>) repositorio.findAll();
	}

	public Repartidor crear(Repartidor repartidor) {
		return repositorio.save(repartidor);
		
	}
	
	public Repartidor actualizar(Repartidor repartidorActualizar) {
		
		// primero realizamos la búsqueda de películas
		Repartidor repartidorActual = repositorio.findById(repartidorActualizar.getId_repartidor()).get();
		
		repartidorActual.setId_repartidor(repartidorActualizar.getId_repartidor());
		repartidorActual.setNombres(repartidorActualizar.getNombres());
		repartidorActual.setTelefono(repartidorActualizar.getTelefono());
		repartidorActual.setDni(repartidorActualizar.getDni());
		repartidorActual.setEstado(repartidorActualizar.getEstado());
		
		Repartidor repartidorActualizado = repositorio.save(repartidorActual);
		return repartidorActualizado;
	}
	
	public Repartidor buscarPorId(Integer id) {
		
		return repositorio.findById(id).get();
		
	}
	
	public void borrarPorId(Integer id) {
		
		repositorio.deleteById(id);
	}
	
	
}
