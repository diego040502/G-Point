package pe.edu.upc.demo.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Tarjeta;

public interface ITarjetaService {
	public void insert(Tarjeta t);

	public List<Tarjeta> list();
	
	public void delete(int idTarjeta);
	
	Optional<Tarjeta> listId(int idTrajeta);
}
