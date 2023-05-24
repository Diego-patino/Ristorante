package certus.edu.pe.modelo;

import java.io.Serializable;


import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@Table(name="usuario")

//Utilizando Lombock
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor

@NamedQueries({
	@NamedQuery(name = "usuario.findAll", query = "SELECT p FROM Usuario p")
    , @NamedQuery(name = "usuario.findByIdUsuario", query = "SELECT p FROM Usuario p WHERE p.id_usuario = :id_usuario")
    , @NamedQuery(name = "usuario.findByNombre", query = "SELECT p FROM Usuario p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "usuario.findByTelefono", query = "SELECT p FROM Usuario p WHERE p.telefono = :telefono")
    , @NamedQuery(name = "usuario.findByDireccion", query = "SELECT p FROM Usuario p WHERE p.direccion = :direccion")
    , @NamedQuery(name = "usuario.findByFechaRegistro", query = "SELECT p FROM Usuario p WHERE p.fecha_registro = :fecha_registro")

})

public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	 
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Basic(optional= true)
		private Integer id_usuario;
		
	    @Basic(optional = false)
	    @Column(name = "nombre")
		private String nombre;

	    @Basic(optional = false)
	    @Column(name = "telefono")
		private Integer telefono;

	    @Basic(optional = false)
	    @Column(name = "direccion")
		private String direccion;

	    @Basic(optional = false)
	    @Column(name = "fecha_registro")
		private String fecha_registro;

			

}
