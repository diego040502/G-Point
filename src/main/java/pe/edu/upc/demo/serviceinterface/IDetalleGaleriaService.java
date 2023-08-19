package pe.edu.upc.demo.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.DetalleGaleria;

public interface IDetalleGaleriaService {

	public void insert(DetalleGaleria dg);

	public List<DetalleGaleria> list();

	public void delete(int idDetalleGaleria);

	Optional<DetalleGaleria> listId(int idDetalleGaleria);

	public void update(DetalleGaleria detallegaleria);

}
