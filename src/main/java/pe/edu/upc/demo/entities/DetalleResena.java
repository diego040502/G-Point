package pe.edu.upc.demo.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "DetalleResenas")
public class DetalleResena {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idDetalleResena;
	
	@ManyToOne
	@NotNull(message="Este campo es requerido")
	@JoinColumn(name = "idResena", nullable = false)
	private Resena resena;

	@ManyToOne
	@NotNull(message="Este campo es requerido")
	@JoinColumn(name = "id", nullable = false)
	private Users usuario;

	@ManyToOne
	@NotNull(message="Este campo es requerido")
	@JoinColumn(name = "idJuego", nullable = false)
	private Juego juego;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message="Indique la fecha de publicación")
	@Column(name = "fechaPublicacion", nullable = false)
	private Date fechaPublicacion;

	public DetalleResena() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public DetalleResena(int id, Resena resena, Users usuario, Juego juego, Date fechaPublicacion) {
		super();
		this.idDetalleResena = id;
		this.resena = resena;
		this.usuario = usuario;
		this.juego = juego;
		this.fechaPublicacion = fechaPublicacion;
	}



	public Resena getResena() {
		return resena;
	}



	public void setResena(Resena resena) {
		this.resena = resena;
	}



	public Users getUsuario() {
		return usuario;
	}



	public void setUsuario(Users usuario) {
		this.usuario = usuario;
	}



	public int getId() {
		return idDetalleResena;
	}

	

	public Juego getJuego() {
		return juego;
	}

	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setId(int id) {
		this.idDetalleResena = id;
	}

	

	public void setJuego(Juego juego) {
		this.juego = juego;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	
	
}
