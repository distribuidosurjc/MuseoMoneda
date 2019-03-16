package museoMoneda;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProveedorRepository extends JpaRepository<Proveedor, Long>{
	Proveedor findByCif(String cif);
	List<Proveedor> findByNombreAndEmailAndDireccionPostal(String nombre, String email, String direccionPostal);
}
