package certus.edu.pe.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import certus.edu.pe.modelo.Usuario;

public interface UsuarioRepositorio extends CrudRepository<Usuario, Integer>{
	
	@Query(value = "SELECT a FROM Usuario a WHERE a.id_usuario =?1")
	public List<Usuario> buscarUsuarioporNombre(String usuario);

}
