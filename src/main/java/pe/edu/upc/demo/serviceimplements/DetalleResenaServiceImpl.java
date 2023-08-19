package pe.edu.upc.demo.serviceimplements;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import pe.edu.upc.demo.entities.DetalleResena;
import pe.edu.upc.demo.repositories.IDetalleResenaRepository;

import pe.edu.upc.demo.serviceinterface.IDetalleResenaService;

@Service
public class DetalleResenaServiceImpl implements IDetalleResenaService{
	
	@Autowired
	private IDetalleResenaRepository drR;
	

	@Override
	public void insert(DetalleResena dr) {
		// TODO Auto-generated method stub
		drR.save(dr);
	}

	@Override
	public List<DetalleResena> list() {
		// TODO Auto-generated method stub
		return drR.findAll();
	}

	
	
}
