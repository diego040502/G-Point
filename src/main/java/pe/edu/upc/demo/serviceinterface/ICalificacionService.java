package pe.edu.upc.demo.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Calificacion;

public interface ICalificacionService {
	
	public void insert(Calificacion calificacion);
	
	public List<Calificacion> list();
	
	public void delete(int idCalificacion);
	
	Optional<Calificacion> listId(int idCalificacion);
	public void update(Calificacion calificacion);
	
}
