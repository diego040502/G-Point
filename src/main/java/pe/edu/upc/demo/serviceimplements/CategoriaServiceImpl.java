package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Categoria;
import pe.edu.upc.demo.repositories.ICategoriaRepository;
import pe.edu.upc.demo.serviceinterface.ICategoriaService;

@Service
public class CategoriaServiceImpl implements ICategoriaService {
	@Autowired
	private ICategoriaRepository categoriaRepository;
	
	@Override
	public void insert(Categoria categoria) {
		// TODO Auto-generated method stub
		categoriaRepository.save(categoria);
	}

	@Override
	public List<Categoria> list() {
		// TODO Auto-generated method stub
		return categoriaRepository.findAll();
	}

	@Override
	public void delete(int idCategoria) {
		// TODO Auto-generated method stub
		categoriaRepository.deleteById(idCategoria);
	}

	@Override
	public Optional<Categoria> listId(int idCategoria) {
		// TODO Auto-generated method stub
		return categoriaRepository.findById(idCategoria);
	}

	@Override
	public void update(Categoria categoria) {
		// TODO Auto-generated method stub
		categoriaRepository.save(categoria);
	}

}
