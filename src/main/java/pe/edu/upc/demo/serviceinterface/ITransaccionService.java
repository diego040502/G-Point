package pe.edu.upc.demo.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Transaccion;

public interface ITransaccionService {
	
	public void insert(Transaccion transaccion);
	
	public List<Transaccion> list();
	
	public void delete(int idTransaccion);
	
	Optional<Transaccion> listId(int idTransaccion);
	public void update(Transaccion transaccion);
	
}
