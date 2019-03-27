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
	@Autowired
	public EjemplarRepository repEjemplar;

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

		if(valor=="" && divisa=="") {
			lista = repMonedas.findAll();
		} else if(divisa=="") {
			lista = repMonedas.findByValor(Integer.parseInt(valor));
		} else if(valor==""){
			lista = repMonedas.findByDivisa(divisa);
		}else {
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

		if(nombre=="" && cif=="") {
			lista = repProveedor.findAll();
		}else if(nombre=="") {
			lista = new ArrayList<Proveedor>();
			lista.add(repProveedor.findById(cif).get());
		}else if(cif==""){
			lista = repProveedor.findByNombre(nombre);
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
	@RequestMapping("/buscar/{src}/{av}/ejem")
	public String buscadoEjemplar(
			@PathVariable(value="src") String src,
			@PathVariable(value="av") String av,
			String estado, String ciudad, String orden,  Model model) {
		
		Comparator<Ejemplar> cmpEjmCiudad = (p1, p2) -> p1.getCiudad().compareTo(p2.getCiudad());
		Comparator<Ejemplar> cmpEjmEstado = (p1, p2) -> p1.getEstado().compareTo(p2.getEstado());
		Comparator<Ejemplar> cmpEjmFecha = (p1, p2) -> p1.getFecha().compareTo(p2.getFecha());
		
		List<Ejemplar> lista;
		
		if(estado=="" && ciudad =="") {
			lista = repEjemplar.findAll();
		}else if(ciudad=="") {
			lista = repEjemplar.findByEstado(estado);
		}else if(estado==""){
			lista = repEjemplar.findByCiudad(ciudad);
		}else {
			lista = repEjemplar.findByEstadoAndCiudad(estado, ciudad);
		}
		
		switch(orden) {
		case "Ciudad":
			lista.sort(cmpEjmCiudad);
			break;
		case "Estado":
			lista.sort(cmpEjmEstado);
			break;
		default:
			lista.sort(cmpEjmFecha);
		}
		
		model.addAttribute("ejemplares", lista);

		return "buscarYmostrar";
		
	}
}