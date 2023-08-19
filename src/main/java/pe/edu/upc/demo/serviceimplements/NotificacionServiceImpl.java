package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Notificacion;
import pe.edu.upc.demo.repositories.INotificacionRepository;
import pe.edu.upc.demo.serviceinterface.INotificacionService;

@Service
public class NotificacionServiceImpl implements INotificacionService{

	@Autowired
	private INotificacionRepository notificacionRepository;
	
	@Override
	public void insert(Notificacion notificacion) {
		// TODO Auto-generated method stub
		notificacionRepository.save(notificacion);
	}

	@Override
	public List<Notificacion> list() {
		// TODO Auto-generated method stub
		return notificacionRepository.findAll();
	}

	@Override
	public void delete(int idNotificacion) {
		// TODO Auto-generated method stub
		notificacionRepository.deleteById(idNotificacion);
	}

	@Override
	public Optional<Notificacion> listId(int idNotificacion) {
		// TODO Auto-generated method stub
		return notificacionRepository.findById(idNotificacion);
	}

	@Override
	public void update(Notificacion notificacion) {
		// TODO Auto-generated method stub
		notificacionRepository.save(notificacion);
	}
	
	
	
}
