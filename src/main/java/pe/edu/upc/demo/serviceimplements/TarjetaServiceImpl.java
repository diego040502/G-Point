package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Tarjeta;
import pe.edu.upc.demo.repositories.ITarjetaRepository;
import pe.edu.upc.demo.serviceinterface.ITarjetaService;

@Service
public class TarjetaServiceImpl implements ITarjetaService {
	@Autowired
	private ITarjetaRepository tarjetaRepository;

	@Override
	public void insert(Tarjeta t) {
		// TODO Auto-generated method stub
		tarjetaRepository.save(t);
	}

	@Override
	public List<Tarjeta> list() {
		// TODO Auto-generated method stub
		return tarjetaRepository.findAll();
	}

	@Override
	public void delete(int idTarjeta) {
		// TODO Auto-generated method stub
		tarjetaRepository.deleteById(idTarjeta);
	}

	@Override
	public Optional<Tarjeta> listId(int idTrajeta) {
		// TODO Auto-generated method stub
		return tarjetaRepository.findById(idTrajeta);
	}

}
