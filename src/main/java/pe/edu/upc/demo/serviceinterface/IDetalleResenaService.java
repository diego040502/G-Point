package pe.edu.upc.demo.serviceinterface;

import java.util.List;

import pe.edu.upc.demo.entities.DetalleResena;


public interface IDetalleResenaService {
	
	public void insert(DetalleResena dr);

	public List<DetalleResena> list();

	
}
