package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.DetalleGaleria;
import pe.edu.upc.demo.repositories.IDetalleGaleriaRepository;
import pe.edu.upc.demo.serviceinterface.IDetalleGaleriaService;

@Service
public class DetalleGaleriaServiceImpl implements IDetalleGaleriaService{
	
	@Autowired
	private IDetalleGaleriaRepository dgR;
	

	@Override
	public void insert(DetalleGaleria dr) {
		// TODO Auto-generated method stub
		dgR.save(dr);
	}

	@Override
	public List<DetalleGaleria> list() {
		// TODO Auto-generated method stub
		return dgR.findAll();
	}
	
	
	public void delete(int idDetalleGaleria) {
		dgR.deleteById(idDetalleGaleria);
	}

	
	

	public Optional<DetalleGaleria> listId(int idDetalleGaleria) {
		
		return dgR.findById(idDetalleGaleria);
	}

	
	
	public void update(DetalleGaleria detallegaleria) {
		dgR.save(detallegaleria);
		
	}
	
	
}
