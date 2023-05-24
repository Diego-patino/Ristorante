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
@Table(name="repartidor")

//Utilizando Lombock
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor

@NamedQueries({
	@NamedQuery(name = "repartidor.findAll", query = "SELECT p FROM Repartidor p")
    , @NamedQuery(name = "repartidor.findByIdRepartidor", query = "SELECT p FROM Repartidor p WHERE p.id_repartidor = :id_repartidor")
    , @NamedQuery(name = "repartidor.findByNombres", query = "SELECT p FROM Repartidor p WHERE p.nombres = :nombres")
    , @NamedQuery(name = "repartidor.findByTelefono", query = "SELECT p FROM Repartidor p WHERE p.telefono = :telefono")
    , @NamedQuery(name = "repartidor.findDNI", query = "SELECT p FROM Repartidor p WHERE p.dni = :dni")
    , @NamedQuery(name = "repartidor.findEstado", query = "SELECT p FROM Repartidor p WHERE p.estado = :estado")

})
	
public class Repartidor implements Serializable{
   
	private static final long serialVersionUID = 1L;
     
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional= true)
	private Integer id_repartidor;
	
    @Basic(optional = false)
    @Column(name = "nombres")
	private String nombres;

    @Basic(optional = false)
    @Column(name = "telefono")
	private Integer telefono;

    @Basic(optional = false)
    @Column(name = "dni")
	private Integer dni;

    @Basic(optional = false)
    @Column(name = "estado")
	private String estado;
	
}
