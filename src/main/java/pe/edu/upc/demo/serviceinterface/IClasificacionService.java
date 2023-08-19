package pe.edu.upc.demo.serviceinterface;

import java.util.List;
import java.util.Optional;


import pe.edu.upc.demo.entities.Clasificacion;

public interface IClasificacionService {
	
public void insert(Clasificacion clasificacion);
	
	public List<Clasificacion> list();
	
	public void delete(int idClasificacion);
	
	Optional<Clasificacion> listId(int idClasificacion);
	
	public void update(Clasificacion clasificacion);
}
