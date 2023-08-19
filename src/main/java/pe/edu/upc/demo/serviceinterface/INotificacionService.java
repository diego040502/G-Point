package pe.edu.upc.demo.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Notificacion;

public interface INotificacionService {
	
	public void insert(Notificacion notificacion);
	
	public List<Notificacion> list();
	
	public void delete(int idNotificacion);
	
	Optional<Notificacion> listId(int idNotificacion);
	public void update(Notificacion notificacion);
	
}
