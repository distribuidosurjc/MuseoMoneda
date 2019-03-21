package museoMoneda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MostrarController {

	@Autowired
	public MonedaRepository repMonedas;
	@Autowired
	public ProveedorRepository repProveedor;

	@RequestMapping("/buscar/{src}")
	public String buscar(
			@PathVariable(value="src") String src,
			Model model) {
		return "buscarYmostrar";
	}
	@RequestMapping("/buscar/{src}/{av}/mon")
	public String buscadoMoneda(
			@PathVariable(value="src") String src,
			@PathVariable(value="av") String av,
			String divisa, String valor, String orden,  Model model) {

		Comparator<Moneda> cmpMonValor = (m1,m2)->m1.getValor() - m2.getValor();
		Comparator<Moneda> cmpMonDivisa = (m1,m2)->m1.getDivisa().compareTo(m2.getDivisa());
		Comparator<Moneda> cmpMonDiametro = (m1,m2)-> (m1.getDiametro() == m2.getDiametro()) ? 0 : (m1.getDiametro() < m2.getDiametro())? -1 : 1 ;
		Comparator<Moneda> cmpMonPeso = (m1,m2)-> (m1.getPeso() == m2.getPeso()) ? 0 : (m1.getPeso() < m2.getPeso())? -1 : 1 ;

		List<Moneda> lista;

		if(valor=="") {
			lista = repMonedas.findByDivisa(divisa);
		} else if(divisa=="") {
			lista = repMonedas.findByValor(Integer.parseInt(valor));
		} else {
			lista = repMonedas.findByDivisaAndValor(divisa, Integer.parseInt(valor));
		}

		switch (orden) {
		case "Divisa":
			lista.sort(cmpMonDivisa);
			break;
		case "Diametro":
			lista.sort(cmpMonDiametro);
			break;
		case "Peso":
			lista.sort(cmpMonPeso);
			break;
		default:
			lista.sort(cmpMonValor);
		}

		model.addAttribute("monedas", lista);

		return "buscarYmostrar";
	}
	@RequestMapping("/buscar/{src}/{av}/pro")
	public String buscadoProveedor(
			@PathVariable(value="src") String src,
			@PathVariable(value="av") String av,
			String nombre, String cif, String orden,  Model model) {

		Comparator<Proveedor> cmpPrvCIF = (p1, p2) -> p1.getCif().compareTo(p2.getCif());
		Comparator<Proveedor> cmpPrvNombre = (p1, p2) -> p1.getNombre().compareTo(p2.getNombre());

		List<Proveedor> lista;

		if(cif=="") {
			lista = repProveedor.findByNombre(nombre);
		}else if(nombre=="") {
			lista = repProveedor.findByCif(cif);
		}else {
			lista = repProveedor.findByCifAndNombre(cif, nombre);
		}
		
		switch(orden) {
		case "CIF":
			lista.sort(cmpPrvCIF);
			break;
		default:
			lista.sort(cmpPrvNombre);
		}

		model.addAttribute("proveedores", lista);

		return "buscarYmostrar";
	}
}