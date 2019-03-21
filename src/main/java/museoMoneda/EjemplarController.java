package museoMoneda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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

		if (!repMonedas.existsById(modelo)) {
			model.addAttribute("error", "No se pudo añadir porque no existe una moneda con este Id.");
			return "error";
		}

		if (!repProveedor.existsById(cif)) {
			model.addAttribute("error", "No se pudo añadir porque no existe un proveedor con este CIF.");
			return "error";
		}


		Ejemplar ejemplar = new Ejemplar(modelo, year, ciudad, fecha, estado, cif);


		String src = "ejemplar";
		model.addAttribute("src", src);
		repEjemplar.save(ejemplar);

		return "hecho";
	}
}