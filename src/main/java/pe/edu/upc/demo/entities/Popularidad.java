package pe.edu.upc.demo.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;



@Entity
@Table (name="Popularidad")
public class Popularidad {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idPopularidad;
	
	@NotNull(message="Este campo es requerido")
	@Pattern(regexp = "[A-Za-z]", message="El tipo de popularidad permite Mayúsculas y minúsculas")
	@Size(min=5,max=10, message="El tipo de popularidad tiene como mínimo 5 letras y máximo 10")
	@Column(name="tipoPopularidad", nullable = false, length = 44)
	private String tipoPopularidad;
	
	public Popularidad() {
		super();
		// TODO Auto-generated constructor stub
	}

	//GETTERS & SETTERS
	
	public int getIdPopularidad() {
		return idPopularidad;
	}


	public void setIdPopularidad(int idPopularidad) {
		this.idPopularidad = idPopularidad;
	}


	public String getTipoPopularidad() {
		return tipoPopularidad;
	}


	public void setTipoPopularidad(String tipoPopularidad) {
		this.tipoPopularidad = tipoPopularidad;
	}
	

	
}
