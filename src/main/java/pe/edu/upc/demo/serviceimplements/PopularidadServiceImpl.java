package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Popularidad;
import pe.edu.upc.demo.repositories.IPopularidadRepository;
import pe.edu.upc.demo.serviceinterface.IPopularidadService;

@Service
public class PopularidadServiceImpl implements IPopularidadService{

	@Autowired
	private IPopularidadRepository popularidadRepository;
	
	@Override
	public void insert(Popularidad popularidad) {
		// TODO Auto-generated method stub
		popularidadRepository.save(popularidad);
	}

	@Override
	public List<Popularidad> list() {
		// TODO Auto-generated method stub
		return popularidadRepository.findAll();
	}

	@Override
	public void delete(int idPopularidad) {
		// TODO Auto-generated method stub
		popularidadRepository.deleteById(idPopularidad);
	}

	@Override
	public Optional<Popularidad> listId(int idPopularidad) {
		// TODO Auto-generated method stub
		return popularidadRepository.findById(idPopularidad);
	}

	@Override
	public void update(Popularidad popularidad) {
		// TODO Auto-generated method stub
		popularidadRepository.save(popularidad);
	}
	
	
}
