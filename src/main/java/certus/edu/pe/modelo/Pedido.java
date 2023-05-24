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
@Table(name="pedido")

@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor

@NamedQueries({
	@NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p")
    , @NamedQuery(name = "Pedido.findByIdPedido", query = "SELECT p FROM Pedido p WHERE p.id_pedido = :id_pedido")
    , @NamedQuery(name = "Pedido.findByFechaHora", query = "SELECT p FROM Pedido p WHERE p.fecha_hora = :fecha_hora")
    , @NamedQuery(name = "Pedido.findByUsuario", query = "SELECT p FROM Pedido p WHERE p.usuario = :usuario")
    , @NamedQuery(name = "Pedido.findByRepartidor", query = "SELECT p FROM Pedido p WHERE p.repartidor = :repartidor")
    , @NamedQuery(name = "Pedido.findDireccion", query = "SELECT p FROM Pedido p WHERE p.direccion = :direccion"),

})
	
public class Pedido implements Serializable{
   
	private static final long serialVersionUID = 1L;
     
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional= true)
	private Integer id_pedido;
	
    @Basic(optional = false)
    @Column(name = "fecha_hora")
	private String fecha_hora;

    @Basic(optional = false)
    @Column(name = "usuario")
	private String usuario;

    @Basic(optional = false)
    @Column(name = "repartidor")
	private String repartidor;

    @Basic(optional = false)
    @Column(name = "direccion")
	private String direccion;
    

	
	
	
	
}
