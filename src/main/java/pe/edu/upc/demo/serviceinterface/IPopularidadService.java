package pe.edu.upc.demo.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Popularidad;

public interface IPopularidadService {

	public void insert(Popularidad popularidad);

	public List<Popularidad> list();

	public void delete(int idPopularidad);

	Optional<Popularidad> listId(int idPopularidad);
	public void update(Popularidad popularidad);
}
