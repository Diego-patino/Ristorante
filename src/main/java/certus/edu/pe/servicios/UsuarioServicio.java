package certus.edu.pe.servicios;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import certus.edu.pe.modelo.Usuario;
import certus.edu.pe.repositorio.UsuarioRepositorio;
import javax.transaction.Transactional;

@Service
@Transactional
public class UsuarioServicio {
	
	@Autowired
	private UsuarioRepositorio repositorio;
	
	
	public List<Usuario> buscarTodo(){
		return (List<Usuario>) repositorio.findAll();
	}

	public Usuario crear(Usuario usuario) {
		return repositorio.save(usuario);
		
	}
	
	public Usuario actualizar(Usuario usuarioActualizar) {
			
			// primero realizamos la búsqueda de películas
			Usuario usuarioActual = repositorio.findById(usuarioActualizar.getId_usuario()).get();
			
			usuarioActual.setId_usuario(usuarioActualizar.getId_usuario());
			usuarioActual.setNombre(usuarioActualizar.getNombre());
			usuarioActual.setTelefono(usuarioActualizar.getTelefono());
			usuarioActual.setDireccion(usuarioActualizar.getDireccion());
			usuarioActual.setFecha_registro(usuarioActualizar.getFecha_registro());
			
			Usuario pedidoActualizado = repositorio.save(usuarioActual);
			return pedidoActualizado;
		}
		
		public Usuario buscarPorId(Integer id) {
			
			return repositorio.findById(id).get();
			
		}
		
		public void borrarPorId(Integer id) {
			
			repositorio.deleteById(id);
		}

}
