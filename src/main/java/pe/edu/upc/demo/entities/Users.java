package pe.edu.upc.demo.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "users")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message="El nombre de usuario es obligatorio")
	@Pattern(regexp="[a-z0-9]")
	@Column(length = 30, unique = true)
	@Size(min=5, max=20, message="El username tiene como mínimo 5 letras y máximo 20")
	private String username;

	@NotNull(message="El password es obligatorio")
	@Column(length = 200)
	private String password;

	private Boolean enabled;
	
	@Column(name="nombre", nullable=false, length=44)
	@NotNull(message="El campo es requerido")
	private String nombre;
	
	@Column(name="apellido", nullable=false, length=44)
	@NotNull(message="El campo es requerido")
	private String apellido;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fechaRegistro", nullable = false)
	private Date fechaRegistro;

	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private List<Role> roles;
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}
