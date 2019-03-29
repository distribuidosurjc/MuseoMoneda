package museoMoneda;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ModificarController {

	@Autowired
	public MonedaRepository repMonedas;
	@Autowired
	public EjemplarRepository repEjemplar;
	@Autowired
	public ProveedorRepository repProveedor;

	// Moneda

	@RequestMapping("/modificar/moneda")
	public String modificarMoneda(@RequestParam int monedaID, Model model) {
		Moneda moneda = repMonedas.findById(monedaID).get();
		model.addAttribute("moneda",moneda);
		model.addAttribute("src", "moneda");
		return "modificar";
	}

	@RequestMapping("/actualizar/moneda")
	public String actualizarMoneda(@RequestParam int monedaID, Integer valor, String divisa, Double diametro, Double peso, String composicion, String descripcion, Model model) {
		Moneda monedaAntigua = repMonedas.findById(monedaID).get();

		int contador = 0;

		if (valor != null) {
			monedaAntigua.setValor(valor);
			contador++;
		} 
		if (divisa != "") {
			monedaAntigua.setDivisa(divisa);
			contador++;
		}
		if (diametro != null) {
			monedaAntigua.setDiametro(diametro);
			contador++;
		}
		if (peso != null) {
			monedaAntigua.setPeso(peso);
			contador++;
		}
		if (composicion != "") {
			monedaAntigua.setComposicion(composicion);
			contador++;
		}
		if (descripcion != "") {
			monedaAntigua.setDescripcion(descripcion);
			contador++;
		}

		if (contador > 0) {
			repMonedas.save(monedaAntigua);
			model.addAttribute("mensaje", "Moneda modificada con Éxito.");
		} else {
			model.addAttribute("mensaje", "No se han realizado cambios.");
		}

		return "hecho";
	}

	// Ejemplar

	@RequestMapping("/modificar/ejemplar")
	public String modificarEjemplar(@RequestParam int ejemplarID, Model model) {
		Ejemplar ejemplar = repEjemplar.findById(ejemplarID).get();
		model.addAttribute("ejemplar", ejemplar);
		model.addAttribute("src", "ejemplar");
		return "modificar";
	}

	@RequestMapping("/actualizar/ejemplar")
	public String actualizarEjemplar(@RequestParam int ejemplarID, Integer modelo, Integer year, String ciudad, Date fecha, String estado, String cif, Model model) throws ParseException {
		
		int contador = 0;
		Ejemplar ejemplarAntiguo = repEjemplar.findById(ejemplarID).get();

		if (modelo != null) {
			contador++;
			Moneda moneda;
			if (!repMonedas.existsById(modelo)) {
				model.addAttribute("error", "No se pudo modificar porque no existe una moneda con este ID.");
				return "error";
			} else {
				moneda = repMonedas.findById(modelo).get();
				ejemplarAntiguo.setMoneda(moneda);
			}
		}

		if (cif != "") {
			contador++;
			Proveedor proveedor;
			if (!repProveedor.existsById(cif)) {
				model.addAttribute("error", "No se pudo modificar porque no existe un proveedor con este CIF.");
				return "error";
			} else {
				proveedor = repProveedor.findById(cif).get();
				ejemplarAntiguo.setProveedor(proveedor);
			}
		}

		if(year != null) {
			contador++;
			ejemplarAntiguo.setYear(year);
		}
		
		if (ciudad != "") {
			contador++;
			ejemplarAntiguo.setCiudad(ciudad);
		}
		
		String fechaPre ="1970-01-01";
		SimpleDateFormat formatoDeFecha = new SimpleDateFormat("yyyy/MM/dd");
		if (!fecha.equals(fechaPre)) {
			contador++;
			ejemplarAntiguo.setFecha(fecha);
		}else {
			fecha= (Date) formatoDeFecha.parse(fechaPre);
		}
		
		if (estado != "") {
			contador++;
			ejemplarAntiguo.setEstado(estado);
		}

		if (contador > 0) {
			repEjemplar.save(ejemplarAntiguo);
			model.addAttribute("mensaje", "Ejemplar modificado con Éxito.");
		} else {
			model.addAttribute("mensaje", "No se han realizado cambios.");
		}

		return "hecho";
	}

	// Proveedor

	@RequestMapping("/modificar/proveedor")
	public String modificarProveedor(@RequestParam String proveedorID, Model model) {
		Proveedor proveedor = repProveedor.findById(proveedorID).get();
		model.addAttribute("proveedor", proveedor);
		model.addAttribute("src", "proveedor");
		return "modificar";
	}

	@RequestMapping("/actualizar/proveedor")
	public String actualizarProveedor(@RequestParam String proveedorID, String nombre, String direccionPostal, String email, Integer  tlf, Model model) {

		int contador = 0;
		Proveedor proveedorAntiguo = repProveedor.findById(proveedorID).get();

		if (nombre != "") {
			contador++;
			proveedorAntiguo.setNombre(nombre);
		}
		if (direccionPostal != "") {
			contador++;
			proveedorAntiguo.setDireccionPostal(direccionPostal);
		}
		if (email != "") {
			contador++;
			proveedorAntiguo.setEmail(email);
		}
		if (tlf != null) {
			contador++;
			proveedorAntiguo.setTlf(tlf);
		}

		if (contador > 0) {
			repProveedor.save(proveedorAntiguo);
			model.addAttribute("mensaje", "Proveedor modificado con Éxito.");
		} else {
			model.addAttribute("mensaje", "No se han realizado cambios.");			
		}

		return "hecho";
	}

}
