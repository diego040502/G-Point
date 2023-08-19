package pe.edu.upc.demo.entities;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Juego")
public class Juego {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idJuego;

	@OneToOne
	@JoinColumn(name = "idCategoria", nullable = false)
	private Categoria categoria;

	@OneToOne
	@JoinColumn(name = "idClasificacion", nullable = false)
	@NotNull(message="Este campo es obligatorio")
	private Clasificacion clasificacion;

	@OneToOne
	@JoinColumn(name = "idCalificacion", nullable = false)
	@NotNull(message="Este campo es obligatorio")
	private Calificacion calificacion;

	@OneToOne
	@JoinColumn(name = "idPopularidad", nullable = false)
	@NotNull(message="Este campo es obligatorio")
	private Popularidad popularidad;

	@Column(name = "nombreJuego", length = 30, nullable = false)
	@NotNull(message="Debe espcificar el nombre del juego")
	@Size(min=5,max=30, message="El nombre tiene como mínimo 5 letras y máximo 30")
	private String nombreJuego;

	@Column(name = "descripcion", length = 200, nullable = false)
	@NotNull(message="La descripcion no puede ser nula")
	@Size(min=10,max=200,message="La descripcion tiene como mínimo 10 letras y máximo 200")
	private String descripcion;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fechaLanzamiento", nullable = false)
	private Date fechaLanzamiento;


	@Column(name = "tamanoJuego", nullable = false)
	@NotNull(message="Este campo es requerido")
	@DecimalMin(value="2.00", message="El tamaño mínimo es de 2GB")
	@DecimalMax(value="30.00", message="El tamaño máximo es de 30GB")
	private int tamanoJuego;

	@Column(name = "precioJuego", nullable = false)
	@NotNull(message="Este campo es requerido")
	@DecimalMin(value="2.00", message="El precio mínimo es de 2 dólares")
	@DecimalMax(value="300.00", message="El precio máximo es de 300 dólares")
	private float precioJuego;
	
	private String Foto;
		
	public Juego() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Juego(int idJuego, Categoria categoria, Clasificacion clasificacion, Calificacion calificacion,
			Popularidad popularidad, String nombreJuego, String descripcion, Date fechaLanzamiento, int tamanoJuego,
			float precioJuego, String foto) {
		super();
		this.idJuego = idJuego;
		this.categoria = categoria;
		this.clasificacion = clasificacion;
		this.calificacion = calificacion;
		this.popularidad = popularidad;
		this.nombreJuego = nombreJuego;
		this.descripcion = descripcion;
		this.fechaLanzamiento = fechaLanzamiento;
		this.tamanoJuego = tamanoJuego;
		this.precioJuego = precioJuego;
		this.Foto = foto;
	}

	public int getIdJuego() {
		return idJuego;
	}

	public void setIdJuego(int idJuego) {
		this.idJuego = idJuego;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Clasificacion getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(Clasificacion clasificacion) {
		this.clasificacion = clasificacion;
	}

	public Calificacion getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Calificacion calificacion) {
		this.calificacion = calificacion;
	}

	public Popularidad getPopularidad() {
		return popularidad;
	}

	public void setPopularidad(Popularidad popularidad) {
		this.popularidad = popularidad;
	}

	public String getNombreJuego() {
		return nombreJuego;
	}

	public void setNombreJuego(String nombreJuego) {
		this.nombreJuego = nombreJuego;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaLanzamiento() {
		return fechaLanzamiento;
	}

	public void setFechaLanzamiento(Date fechaLanzamiento) {
		this.fechaLanzamiento = fechaLanzamiento;
	}

	public int getTamanoJuego() {
		return tamanoJuego;
	}

	public void setTamanoJuego(int tamanoJuego) {
		this.tamanoJuego = tamanoJuego;
	}

	public float getPrecioJuego() {
		return precioJuego;
	}

	public void setPrecioJuego(float precioJuego) {
		this.precioJuego = precioJuego;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idJuego);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Juego other = (Juego) obj;
		return idJuego == other.idJuego;
	}

	public String getFoto() {
		return Foto;
	}

	public void setFoto(String foto) {
		Foto = foto;
	}
	

	
	
	

}
