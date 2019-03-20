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
	
	/*
	 * 		Comparator<Moneda> cmpMonValor = (m1,m2)->m1.getValor() - m2.getValor();
		Comparator<Moneda> cmpMonDivisa = (m1,m2)->m1.getDivisa().compareTo(m2.getDivisa());
		Comparator<Moneda> cmpMonDiametro = (m1,m2)-> (m1.getDiametro() == m2.getDiametro()) ? 0 : (m1.getDiametro() < m2.getDiametro())? -1 : 1 ;
		Comparator<Moneda> cmpMonPeso = (m1,m2)-> (m1.getPeso() == m2.getPeso()) ? 0 : (m1.getPeso() < m2.getPeso())? -1 : 1 ;

		Comparator<Proveedor> cmpPrvCIF = (p1, p2) -> p1.get
		Comparator<Proveedor> cmpPrvNombre = (p1, p2) -> p1.get
	 */
	
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
			String divisa, String valor,  Model model) {
		
		if(valor=="") {
			model.addAttribute("monedas", repMonedas.findByDivisa(divisa));
		}else if(divisa=="") {
			model.addAttribute("monedas", repMonedas.findByValor(Integer.parseInt(valor)));
		}else {
			model.addAttribute("monedas", repMonedas.findByDivisaAndValor(divisa, Integer.parseInt(valor)));
		}
		
		return "buscarYmostrar";
	}
	@RequestMapping("/buscar/{src}/{av}/pro")
	public String buscadoProveedor(
			@PathVariable(value="src") String src,
			@PathVariable(value="av") String av,
			String nombre, Model model) {
		
		model.addAttribute("proveedores", repProveedor.findByNombre(nombre));
		
		return "buscarYmostrar";
	}
}