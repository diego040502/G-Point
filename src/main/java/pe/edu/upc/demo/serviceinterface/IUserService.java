package pe.edu.upc.demo.serviceinterface;

import java.util.List;

import pe.edu.upc.demo.entities.Users;

public interface IUserService {
	public void insertar(Users u);

	List<Users> listar();

}
