package pe.edu.upc.demo.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Galeria;

public interface IGaleriaService {
	
	public void inset(Galeria galeria);
	
	public List<Galeria> list();
	
	public void delete(int idGaleria);
	
	Optional<Galeria>listId(int idGaleria);
	
	public void update (Galeria galeria);

	
}
