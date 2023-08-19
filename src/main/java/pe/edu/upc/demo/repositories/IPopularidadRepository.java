package pe.edu.upc.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.demo.entities.Popularidad;

@Repository
public interface IPopularidadRepository extends JpaRepository<Popularidad, Integer>{
	
}
