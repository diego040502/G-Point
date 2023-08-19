package pe.edu.upc.demo.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Resena;


public interface IResenaService {
	
	public void insert(Resena resena);

	public List<Resena> list();

	public void delete(int idResena);

	Optional<Resena> listId(int idResena);

	public void update(Resena resena);
}
