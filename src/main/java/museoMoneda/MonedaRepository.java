package museoMoneda;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MonedaRepository extends JpaRepository<Moneda, Integer> {
	Moneda findByModelo(int modelo);
	List<Moneda> findByDivisa(String divisa);
	List<Moneda> findByValor(int valor);
	List<Moneda> findByDivisaAndValor(String divisa, int valor);
}
