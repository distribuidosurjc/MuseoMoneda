package museoMoneda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;

@Controller
public class EjemplarController {

	@Autowired
	public MonedaRepository repMonedas;
	@Autowired
	public ProveedorRepository repProveedor;
	@Autowired
	public EjemplarRepository repEjemplar;

	@RequestMapping("/insertar/ejemplar")
	public String insertar(int modelo, int year, String ciudad, Date fecha, String estado, String cif, Model model) {
		
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