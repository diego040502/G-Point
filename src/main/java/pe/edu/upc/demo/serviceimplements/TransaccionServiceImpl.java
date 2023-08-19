package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Transaccion;
import pe.edu.upc.demo.repositories.ITransaccionRepository;
import pe.edu.upc.demo.serviceinterface.ITransaccionService;

@Service
public class TransaccionServiceImpl implements ITransaccionService{

	@Autowired
	private ITransaccionRepository transaccionRepository;
	
	@Override
	public void insert(Transaccion transaccion) {
		// TODO Auto-generated method stub
		transaccionRepository.save(transaccion);
	}

	@Override
	public List<Transaccion> list() {
		// TODO Auto-generated method stub
		return transaccionRepository.findAll();
	}

	@Override
	public void delete(int idTransaccion) {
		// TODO Auto-generated method stub
		transaccionRepository.deleteById(idTransaccion);
	}

	@Override
	public Optional<Transaccion> listId(int idTransaccion) {
		// TODO Auto-generated method stub
		return transaccionRepository.findById(idTransaccion);
	}

	@Override
	public void update(Transaccion transaccion) {
		// TODO Auto-generated method stub
		transaccionRepository.save(transaccion);
	}
	
	
	
}
