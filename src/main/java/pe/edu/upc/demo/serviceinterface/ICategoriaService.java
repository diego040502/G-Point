package pe.edu.upc.demo.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Categoria;

public interface ICategoriaService {
	public void insert(Categoria categoria);
	
	public List<Categoria> list();
	
	public void delete(int idCategoria);
	
	Optional<Categoria> listId(int idCategoria);
	
	public void update(Categoria categoria);
}
