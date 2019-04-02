package museoMoneda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
			String divisa, String valor, String peso, String orden,  Model model) {

		Comparator<Moneda> cmpMonValor = (m1,m2)->m1.getValor() - m2.getValor();
		Comparator<Moneda> cmpMonDivisa = (m1,m2)->m1.getDivisa().compareToIgnoreCase(m2.getDivisa());
		Comparator<Moneda> cmpMonDiametro = (m1,m2)-> Double.compare(m1.getDiametro(), m2.getDiametro());
		Comparator<Moneda> cmpMonPeso = (m1,m2)-> Double.compare(m1.getPeso(), m2.getPeso());

		List<Moneda> lista;

		if(valor=="" && divisa=="" && peso=="") { // Todas
			model.addAttribute("mensaje", "Todas las Monedas");
			lista = repMonedas.findAll();
		} else {
			if(divisa=="" && valor=="") { // Por peso
				lista = repMonedas.findByPeso(Double.parseDouble(peso));
			} else if(valor=="" && peso==""){ // Por divisa
				lista = repMonedas.findByDivisa(divisa);
			}else if(divisa=="" && peso==""){ // Por valor
				lista = repMonedas.findByValor(Integer.parseInt(valor));
			}else if(divisa=="") { // Por valor y peso
				lista = repMonedas.findByValorAndPeso(Integer.parseInt(valor), Double.parseDouble(peso));
			}else if(peso=="") { // Por divisa y valor
				lista = repMonedas.findByDivisaAndValor(divisa, Integer.parseInt(valor));
			}else if(valor=="") { // Por divisa y peso
				lista = repMonedas.findByDivisaAndPeso(divisa, Double.parseDouble(peso));
			}else { // Por todo
				lista = repMonedas.findByDivisaAndValorAndPeso(divisa, Integer.parseInt(valor), Double.parseDouble(peso));
			}

			if (lista.size()>1) {
				model.addAttribute("mensaje", "Monedas Encontradas");
			} else {
				model.addAttribute("mensaje", "Moneda Encontrada");
			}
		}


		switch (orden) {
		case "Divisa":
			lista.sort(cmpMonDivisa);
			break;
		case "Diámetro":
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

		Comparator<Proveedor> cmpPrvCIF = (p1, p2) -> p1.getCif().compareToIgnoreCase(p2.getCif());
		Comparator<Proveedor> cmpPrvNombre = (p1, p2) -> p1.getNombre().compareToIgnoreCase(p2.getNombre());

		List<Proveedor> lista;

		if(nombre=="" && cif=="") { // Todos
			lista = repProveedor.findAll();
			model.addAttribute("mensaje", "Todos las Proveedores");
		} else {
			if(nombre=="") { // Por cif
				lista = new ArrayList<Proveedor>();
				lista.add(repProveedor.findById(cif).get());
			} else if(cif==""){ // Por nombre
				lista = repProveedor.findByNombre(nombre);
			} else { // Por cif y nombre
				lista = repProveedor.findByCifAndNombre(cif, nombre);
			}

			if (lista.size()>1) {
				model.addAttribute("mensaje", "Proveedores Encontrados");
			} else {
				model.addAttribute("mensaje", "Proveedor Encontrado");
			}
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
			String ciudad, String cif, String divisa, String orden,  Model model) {

		Comparator<Ejemplar> cmpEjmCiudad = (p1, p2) -> p1.getCiudad().compareToIgnoreCase(p2.getCiudad());
		Comparator<Ejemplar> cmpEjmEstado = (p1, p2) -> p1.getEstado().compareToIgnoreCase(p2.getEstado());
		Comparator<Ejemplar> cmpEjmFecha = (p1, p2) -> p1.getFecha().compareTo(p2.getFecha());

		List<Ejemplar> lista;

		if(ciudad =="" && divisa == "" && cif == "") { // Todos
			lista = repEjemplar.findAll();
			model.addAttribute("mensaje", "Todos los Ejemplares");
		} else { 
			if(divisa =="" && cif == "") { // Sólo ciudad
				lista = repEjemplar.findByCiudad(ciudad);
			} else if(ciudad =="" && cif == ""){ // Sólo divisa
				lista = repEjemplar.findByMoneda_divisa(divisa);
			} else if(divisa =="" && ciudad == ""){ // Sólo CIF
				lista = repEjemplar.findByProveedor_cif(cif);
			} else if(cif == "") { // Divisa y Ciudad
				lista = repEjemplar.findByMoneda_divisaAndCiudad(divisa, ciudad);
			} else if (ciudad == "") { // Divisa y CIF
				lista = repEjemplar.findByMoneda_divisaAndProveedor_cif(divisa, cif);
			} else if (divisa == "") { // Ciudad y Cif
				lista = repEjemplar.findByCiudadAndProveedor_cif(ciudad, cif);
			} else { // todos llenos
				lista = repEjemplar.findByCiudadAndMoneda_divisaAndProveedor_cif(ciudad, divisa, cif);
			}

			if (lista.size()>1) {
				model.addAttribute("mensaje", "Ejemplares Encontrados");
			} else {
				model.addAttribute("mensaje", "Ejemplar Encontrado");
			}
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