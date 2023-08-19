package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Galeria;
import pe.edu.upc.demo.repositories.IGaleriaRepository;
import pe.edu.upc.demo.serviceinterface.IGaleriaService;

@Service
public class GaleriaServiceImpl implements IGaleriaService{
	
	@Autowired
	private IGaleriaRepository galeriaRepository;
	
	@Override
	public void inset(Galeria galeria) {
		galeriaRepository.save(galeria);
		    
		
	}

	@Override
	public List<Galeria> list() {
		
		return galeriaRepository.findAll();
	}

	
	
	@Override
	public void delete(int idGaleria) {
		galeriaRepository.deleteById(idGaleria);
		
	}

	
	
	@Override
	public Optional<Galeria> listId(int idGaleria) {
		
		return galeriaRepository.findById(idGaleria);
	}

	
	@Override
	public void update(Galeria galeria) {
		galeriaRepository.save(galeria);
		
	}
	 

}
