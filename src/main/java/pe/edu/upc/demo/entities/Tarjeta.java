package pe.edu.upc.demo.entities;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Tarjeta")
public class Tarjeta {
	
	@Id
	@Column(name = "numeroTarjeta", nullable = false)
	@NotNull(message="Este campo no debe estar vacío")
	private int numeroTarjeta;
	
	@ManyToOne
	@JoinColumn(name = "idUsuario", nullable = false)
	@NotNull(message="El usuario es un campo requerido")
	private Users usuario;
	
	@NotNull(message="El nombre de la tarjea es obligatorio")
	@Column(name = "nombreTarjeta", length = 30, nullable = false)
	private String nombreTarjeta;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fechaExpiracion", nullable = false)
	private Date fechaExpiracion;
	
	@NotNull(message="El código CVV es obligatorio")
	@Min(value= 3)
	@Max(value = 3, message="El código CVV permite máximo 3 digitos")
	@Column(name = "codigoCvv", nullable = false)
	private int codigoCvv;

	public Tarjeta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tarjeta(int numeroTarjeta, Users usuario, String nombreTarjeta, Date fechaExpiracion, int codigoCvv) {
		super();
		this.numeroTarjeta = numeroTarjeta;
		this.usuario = usuario;
		this.nombreTarjeta = nombreTarjeta;
		this.fechaExpiracion = fechaExpiracion;
		this.codigoCvv = codigoCvv;
	}

	public int getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public Users getUsuario() {
		return usuario;
	}

	public String getNombreTarjeta() {
		return nombreTarjeta;
	}

	public Date getFechaExpiracion() {
		return fechaExpiracion;
	}

	public int getCodigoCvv() {
		return codigoCvv;
	}

	public void setNumeroTarjeta(int numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public void setUsuario(Users usuario) {
		this.usuario = usuario;
	}

	public void setNombreTarjeta(String nombreTarjeta) {
		this.nombreTarjeta = nombreTarjeta;
	}

	public void setFechaExpiracion(Date fechaExpiracion) {
		this.fechaExpiracion = fechaExpiracion;
	}

	public void setCodigoCvv(int codigoCvv) {
		this.codigoCvv = codigoCvv;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoCvv, fechaExpiracion, nombreTarjeta, numeroTarjeta, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarjeta other = (Tarjeta) obj;
		return codigoCvv == other.codigoCvv && Objects.equals(fechaExpiracion, other.fechaExpiracion)
				&& Objects.equals(nombreTarjeta, other.nombreTarjeta) && numeroTarjeta == other.numeroTarjeta
				&& Objects.equals(usuario, other.usuario);
	}
	
	
}
