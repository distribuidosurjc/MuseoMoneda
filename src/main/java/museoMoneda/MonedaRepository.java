package museoMoneda;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MonedaRepository extends JpaRepository<Moneda, Integer> {
	List<Moneda> findByDivisa(String divisa);
	List<Moneda> findByValor(int valor);
	List<Moneda> findByPeso(double peso);
	List<Moneda> findByDivisaAndValor(String divisa, int valor);
	List<Moneda> findByDivisaAndPeso(String divisa, double peso);
	List<Moneda> findByValorAndPeso(int valor, double peso);
	List<Moneda> findByDivisaAndValorAndPeso(String divisa, int valor, double peso);
}
