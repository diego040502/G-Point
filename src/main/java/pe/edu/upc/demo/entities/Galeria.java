package pe.edu.upc.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
@Table(name="Galeria")
public class Galeria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idGaleria;
	
	@Column(name = "nombreGaleria", nullable = false, length = 44 )
	@NotNull(message="Especifique el nombre de la galería")
	@Size(min=10, max=30, message="El nombre tiene mínimo 10 letras y máximo 30")
	private String nombreGaleria;
	
	@Column(name = "cantidadJuegos", nullable = false, length = 20 )
	@NotNull(message="Este campo es requerido")
	private String cantidadJuegos;

	
	
	public Galeria() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Galeria(int idGaleria, String nombreGaleria, String cantidadJuegos) {
		super();
		this.idGaleria = idGaleria;
		this.nombreGaleria = nombreGaleria;
		this.cantidadJuegos = cantidadJuegos;
	}

	
	
	
	public int getIdGaleria() {
		return idGaleria;
	}

	public void setIdGaleria(int idGaleria) {
		this.idGaleria = idGaleria;
	}

	public String getNombreGaleria() {
		return nombreGaleria;
	}

	public void setNombreGaleria(String nombreGaleria) {
		this.nombreGaleria = nombreGaleria;
	}

	public String getCantidadJuegos() {
		return cantidadJuegos;
	}

	public void setCantidadJuegos(String cantidadJuegos) {
		this.cantidadJuegos = cantidadJuegos;
	}
	
	
	
	
	
	
	
	

}
