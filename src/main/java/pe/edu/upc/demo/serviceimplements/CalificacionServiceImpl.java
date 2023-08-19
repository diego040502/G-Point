package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Calificacion;
import pe.edu.upc.demo.repositories.ICalificacionRepository;
import pe.edu.upc.demo.serviceinterface.ICalificacionService;

@Service
public class CalificacionServiceImpl implements ICalificacionService{

	@Autowired
	private ICalificacionRepository calificacionRepository;
	
	@Override
	public void insert(Calificacion calificacion) {
		// TODO Auto-generated method stub
		calificacionRepository.save(calificacion);
	}

	@Override
	public List<Calificacion> list() {
		// TODO Auto-generated method stub
		return calificacionRepository.findAll();
	}

	@Override
	public void delete(int idCalificacion) {
		// TODO Auto-generated method stub
		calificacionRepository.deleteById(idCalificacion);
	}

	@Override
	public Optional<Calificacion> listId(int idCalificacion) {
		// TODO Auto-generated method stub
		return calificacionRepository.findById(idCalificacion);
	}

	@Override
	public void update(Calificacion calificacion) {
		// TODO Auto-generated method stub
		calificacionRepository.save(calificacion);
	}
	
	
	
}
