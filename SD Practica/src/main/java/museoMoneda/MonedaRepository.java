package museoMoneda;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MonedaRepository extends JpaRepository<Moneda, Long> {
	Moneda findByModelo(String modelo);
	List<Moneda> findByDivisa(String divisa);
	List<Moneda> findByValor(int valor);
}
