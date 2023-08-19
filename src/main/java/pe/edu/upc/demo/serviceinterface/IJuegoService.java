package pe.edu.upc.demo.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Juego;




public interface IJuegoService {
	public Integer insert(Juego j);

	public List<Juego> list();
	
	Optional<Juego> listarId(int idJuego);
	
	public List<String[]> resenaJuego();
		

}
