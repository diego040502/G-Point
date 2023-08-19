package pe.edu.upc.demo.serviceinterface;

import java.util.List;

import pe.edu.upc.demo.entities.Role;

public interface IRoleService {
	public void insertar(Role r);

	List<Role> listar();

}
