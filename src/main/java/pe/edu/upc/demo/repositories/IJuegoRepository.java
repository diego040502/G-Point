package pe.edu.upc.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.demo.entities.Juego;

@Repository
public interface IJuegoRepository extends JpaRepository<Juego, Integer> {
	@Query("select count(j.nombreJuego) from Juego j where j.nombreJuego =:nombreJuego")
	public int buscarNombreJuego(@Param("nombreJuego") String nombreJuego);
	
	@Query(value = "Select j.nombre_juego, count(d.id_detalle_resena) from juego j join detalle_resenas d on j.id_juego = d.id_juego group by j.nombre_juego", nativeQuery = true)
	public List<String[]> resenaJuego();
}
