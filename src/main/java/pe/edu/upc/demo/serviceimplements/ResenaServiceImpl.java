package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Resena;
import pe.edu.upc.demo.repositories.IResenaRepository;
import pe.edu.upc.demo.serviceinterface.IResenaService;

@Service
public class ResenaServiceImpl implements IResenaService {
	
	@Autowired
	private IResenaRepository resenaRepository;
	
	@Override
	public void insert(Resena resena) {
		resenaRepository.save(resena);
		
	}

	@Override
	public List<Resena> list() {
		
		return resenaRepository.findAll();
	}

	@Override
	public void delete(int idResena) {
		resenaRepository.deleteById(idResena);
		
	}

	@Override
	public Optional<Resena> listId(int idResena) {
		
		return resenaRepository.findById(idResena);
	}

	@Override
	public void update(Resena resena) {
		resenaRepository.save(resena);
		
	}

}
