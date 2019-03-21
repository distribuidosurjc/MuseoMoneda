package museoMoneda;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface EjemplarRepository extends JpaRepository<Ejemplar, Integer>{
	List<Ejemplar> findByCiudad(String ciudad);
}