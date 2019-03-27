package museoMoneda;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InsertarController {

	@Autowired
	public MonedaRepository repMonedas;
	@Autowired
	public ProveedorRepository repProveedor;
	@Autowired
	public EjemplarRepository repEjemplar;
	
	@RequestMapping("/crear/{src}")
	public String crear(
			@PathVariable(value="src") String src,
			Model model) {

		return "crear";
	}
	
	@RequestMapping("/insertar/moneda")
	public String insertarMoneda(Moneda moneda, Model model) {
		repMonedas.save(moneda);
		model.addAttribute("mensaje", "Moneda creada con Éxito.");
		return "hecho";
	}
	
	@RequestMapping("/insertar/proveedor")
	public String insertarProveedor(Proveedor proveedor, Model model) {
		if(! repProveedor.existsById(proveedor.getCif())){
			repProveedor.save(proveedor);
			model.addAttribute("mensaje", "Proveedor creado con Éxito.");
			return  "hecho";
		}else {
			model.addAttribute("error", "No se pudo añadir porque ya existe un proveedor con ese CIF.");
			return "error";
		}
	}

	@RequestMapping("/insertar/ejemplar")
	public String insertarEjemplar(int modelo, int year, String ciudad, Date fecha, String estado, String cif, Model model) {
		
		Moneda moneda;
		Proveedor proveedor;
		
		if (!repMonedas.existsById(modelo)) {
			model.addAttribute("error", "No se pudo añadir porque no existe una moneda con este Id.");
			return "error";
		} else {
			moneda = repMonedas.findById(modelo).get();
		}

		if (!repProveedor.existsById(cif)) {
			model.addAttribute("error", "No se pudo añadir porque no existe un proveedor con este CIF.");
			return "error";
		} else {
			proveedor = repProveedor.findById(cif).get();
		}


		Ejemplar ejemplar = new Ejemplar(moneda, year, ciudad, fecha, estado, proveedor);
		repEjemplar.save(ejemplar);
	
		model.addAttribute("mensaje", "Ejemplar creado con Éxito.");
		return "hecho";
	}
	
}