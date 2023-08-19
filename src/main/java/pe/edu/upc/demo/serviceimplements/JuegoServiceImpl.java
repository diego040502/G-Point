package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.demo.entities.Juego;
import pe.edu.upc.demo.repositories.IJuegoRepository;
import pe.edu.upc.demo.serviceinterface.IJuegoService;

@Service
public class JuegoServiceImpl implements IJuegoService {

	@Autowired
	private IJuegoRepository jR;

	@Override
	public List<Juego> list() {
		// TODO Auto-generated method stub
		return jR.findAll();
	}

	@Override
	public Integer insert(Juego j) {
		int rpta = jR.buscarNombreJuego(j.getNombreJuego());
		if (rpta == 0) {
			jR.save(j);
		}
		return rpta;
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Juego> listarId(int idJuego) {
		return jR.findById(idJuego);
	}

	@Override
	public List<String[]> resenaJuego() {
		
		return jR.resenaJuego();
	}


	}

