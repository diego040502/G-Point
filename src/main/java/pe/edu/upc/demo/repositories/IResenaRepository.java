package pe.edu.upc.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.demo.entities.Resena;

@Repository
public interface IResenaRepository extends JpaRepository<Resena, Integer>{

}
