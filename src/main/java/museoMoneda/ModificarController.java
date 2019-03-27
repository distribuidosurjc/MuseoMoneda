package museoMoneda;

import java.sql.Date;

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

		return "modificar";
	}

	/*@RequestMapping("/actualizar/moneda")
	public String actualizar(@RequestParam int monedaID, Moneda moneda, Model model) {
		Moneda monedaAntigua = repMonedas.findById(monedaID).get();
		monedaAntigua.actualizar(moneda);
		repMonedas.save(monedaAntigua);
		moneda = null;
		model.addAttribute("mensaje", "Moneda modificada con Éxito.");
		return "hecho";
	}*/

	@RequestMapping("/actualizar/moneda")
	public String actualizarMoneda(@RequestParam int monedaID, int valor, String divisa, double diametro, double peso, String composicion, String descripcion, Model model) {
		Moneda monedaAntigua = repMonedas.findById(monedaID).get();
		
		monedaAntigua.setValor(valor);
		monedaAntigua.setDivisa(divisa);
		monedaAntigua.setDiametro(diametro);
		monedaAntigua.setPeso(peso);
		monedaAntigua.setComposicion(composicion);
		monedaAntigua.setDescripcion(descripcion);
		
		repMonedas.save(monedaAntigua);
		model.addAttribute("mensaje", "Moneda modificada con Éxito.");
		return "hecho";
	}
	
	// Ejemplar
	
	@RequestMapping("/modificar/ejemplar")
	public String modificarEjemplar(@RequestParam int ejemplarID, Model model) {
		Ejemplar ejemplar = repEjemplar.findById(ejemplarID).get();
		model.addAttribute("ejemplar", ejemplar);

		return "modificar";
	}

	@RequestMapping("/actualizar/ejemplar")
	public String actualizarEjemplar(@RequestParam String ejemplarID, int modelo, int year, String ciudad, Date fecha, String estado, String cif, Model model) {
		
		Moneda moneda;
		Proveedor proveedor;
		
		if (!repMonedas.existsById(modelo)) {
			model.addAttribute("error", "No se pudo modificar porque no existe una moneda con este ID.");
			return "error";
		} else {
			moneda = repMonedas.findById(modelo).get();
		}

		if (!repProveedor.existsById(cif)) {
			model.addAttribute("error", "No se pudo modificar porque no existe un proveedor con este CIF.");
			return "error";
		} else {
			proveedor = repProveedor.findById(cif).get();
		}

		Ejemplar ejemplarAntiguo = repEjemplar.findById(modelo).get();
		ejemplarAntiguo.setYear(year);
		ejemplarAntiguo.setCiudad(ciudad);
		ejemplarAntiguo.setFecha(fecha);
		ejemplarAntiguo.setEstado(estado);
		ejemplarAntiguo.setMoneda(moneda);
		ejemplarAntiguo.setProveedor(proveedor);

		repEjemplar.save(ejemplarAntiguo);
		model.addAttribute("mensaje", "Ejemplar modificado con Éxito.");
		
		return "hecho";
	}
	
	
	
	// Proveedor
	
	@RequestMapping("/modificar/proveedor")
	public String modificarProveedor(@RequestParam String proveedorID, Model model) {
		Proveedor proveedor = repProveedor.findById(proveedorID).get();
		model.addAttribute("proveedor", proveedor);

		return "modificar";
	}
	
	@RequestMapping("/actualizar/proveedor")
	public String actualizarProveedor(@RequestParam String proveedorID, Proveedor proveedor, Model model) {
		Proveedor proveedorAntiguo = repProveedor.findById(proveedorID).get();
//		proveedorAntiguo.actualizar(proveedor);
		repProveedor.save(proveedorAntiguo);
		proveedor = null;
		model.addAttribute("mensaje", "Proveedor modificado con Éxito.");
		return "hecho";
	}

}
