package museoMoneda;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProveedorRepository extends JpaRepository<Proveedor, String>{
	List<Proveedor> findByNombre(String nombre);
	List<Proveedor> findByCifAndNombre(String cif, String nombre);
}
