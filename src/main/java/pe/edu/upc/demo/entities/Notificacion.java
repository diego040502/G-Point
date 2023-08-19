package pe.edu.upc.demo.entities;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
@Table (name="Notificacion")
public class Notificacion {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idNotificacion;
	
	@NotNull(message = "Debes especificar el id de usuario")
	@ManyToOne
	@JoinColumn(name = "idUsuario", nullable = false)
	private Users usuario;
	
	@NotNull(message = "Debes especificar el id del juego")
	@ManyToOne
	@JoinColumn(name = "idJuego", nullable = false)
	private Juego juego;
	
	@NotNull(message = "Debe especificar el mensaje a mostrar")
	@Column(name="mensaje", nullable = false, length = 44)
	@Size(min=10,max=200, message="El mensaje contiene mínimo 10 letras y máximo 200")
	private String mensaje;
	
	@NotNull(message = "Debe especificar el estado de la notificacion")
	@Size(min=2, max=2, message="Este campo tiene como mínimo 2 letras y máximo 2")
	@Column(name="notificacionActiva", nullable = false, length = 44)
	private String notificacionActiva;

	
	public Notificacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Notificacion(int id, Users usuario, Juego juego,  String mensaje, String notificacionActiva) {
		super();
		this.idNotificacion = id;
		this.usuario = usuario;
		this.juego = juego;
		this.mensaje = mensaje;
		this.notificacionActiva = notificacionActiva;
	}

	//GETTERS & SETTERS
	
	public int getIdNotificacion() {
		return idNotificacion;
	}

	public void setIdNotificacion(int idNotificacion) {
		this.idNotificacion = idNotificacion;
	}

	public Users getUsuario() {
		return usuario;
	}

	public void setUsuario(Users usuario) {
		this.usuario = usuario;
	}

	public Juego getJuego() {
		return juego;
	}

	public void setJuego(Juego juego) {
		this.juego = juego;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getNotificacionActiva() {
		return notificacionActiva;
	}

	public void setNotificacionActiva(String notificacionActiva) {
		this.notificacionActiva = notificacionActiva;
	}
	
	
	
}
