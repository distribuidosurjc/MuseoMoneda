package museoMoneda;

import java.sql.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@Autowired
	public MonedaRepository repMonedas;
	@Autowired
	public ProveedorRepository repProveedor;
	@Autowired
	public EjemplarRepository repEjemplar;
	
	@PostConstruct
	public void init() {
		Moneda m1 = new Moneda(1, "doblón español", 5.0, 6.77, "Oro", "Mojado");
		repMonedas.save(m1);
		Moneda m2 = new Moneda(6, "dolar", 1.3, 7.4, "Cobre", "Abollada");
		repMonedas.save(m2);
		repMonedas.save(new Moneda(6, "dolar", 1.3, 7.4, "Zinc", "Olorosa"));
		repMonedas.save(new Moneda(6, "yen", 2, 4, "Cobre", "Reluciente"));
		repMonedas.save(new Moneda(17, "yen", 13, 7, "Bronce", "Doblada"));
		repMonedas.save(new Moneda(50, "dolar", 6.6, 1.4, "Plata", "Maravillosa"));
		
		Proveedor p1 = new Proveedor("B0000000A", "Calderilla", "Calle Falsa 123", "correo@calderilla.dom", 972240765);
		repProveedor.save(p1);
		Proveedor p2 = new Proveedor("A12345678", "URJC", "Calle Tulipán S/N", "dineros@urjc.es", 912345678);
		repProveedor.save(p2);
		repProveedor.save(new Proveedor("B12345678", "URJC", "Calle Tulipán S/N", "parne@urjc.es", 912345678));
		repProveedor.save(new Proveedor("C2135467Z", "UcM", "Calle Tulipán S/N", "ali@express.es", 123456789));
		repProveedor.save(new Proveedor("D31256748", "Cifuentes", "Calle Tulipán S/N", "jojo@dio.es", 876389076));

		repEjemplar.save(new Ejemplar(m1, 1967, "Frankfurt", Date.valueOf("1988-12-30"), "SC", p2));
		repEjemplar.save(new Ejemplar(m2, 1865, "Leganés", Date.valueOf("1865-6-15"), "BC", p2));
		
	}
		
	@RequestMapping("/")
	public String tablon(Model model) {
			
		model.addAttribute("monedas", repMonedas.findAll());

		return "index";
	}
	
}