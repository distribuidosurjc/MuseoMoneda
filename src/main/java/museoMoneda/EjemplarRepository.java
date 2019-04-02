package museoMoneda;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EjemplarRepository extends JpaRepository<Ejemplar, Integer>{
	List<Ejemplar> findByProveedor_cif(String cif);
	List<Ejemplar> findByMoneda_modelo(int modelo);
	List<Ejemplar> findByCiudad(String ciudad);
	List<Ejemplar> findByEstado(String estado);
	List<Ejemplar> findByEstadoAndCiudad(String estado, String ciudad);
	List<Ejemplar> findByMoneda_divisa(String divisa);
	List<Ejemplar> findByMoneda_divisaAndCiudad(String divisa, String ciudad);
	List<Ejemplar> findByMoneda_divisaAndProveedor_cif(String divisa, String cif);
	List<Ejemplar> findByCiudadAndProveedor_cif(String ciudad, String cif);
	List<Ejemplar> findByCiudadAndMoneda_divisaAndProveedor_cif(String ciudad, String divisa, String cif);
}