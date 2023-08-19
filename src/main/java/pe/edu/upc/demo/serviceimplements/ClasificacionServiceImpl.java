package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Clasificacion;
import pe.edu.upc.demo.repositories.IClasificacionRepository;
import pe.edu.upc.demo.serviceinterface.IClasificacionService;

@Service
public class ClasificacionServiceImpl implements IClasificacionService {
	
	@Autowired
	private IClasificacionRepository clasificacionRepository;
	
	@Override
	public void insert(Clasificacion clasificacion) {
		clasificacionRepository.save(clasificacion);
		
	}

	@Override
	public List<Clasificacion> list() {
		
		return clasificacionRepository.findAll();
	}

	@Override
	public void delete(int idClasificacion) {
		clasificacionRepository.deleteById(idClasificacion);
		
	}

	@Override
	public Optional<Clasificacion> listId(int idClasificacion) {
		
		return clasificacionRepository.findById(idClasificacion);
	}

	@Override
	public void update(Clasificacion clasificacion) {
		clasificacionRepository.save(clasificacion);
		
	}

}
