package museoMoneda;

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
	
	@PostConstruct
	public void init() {
		repMonedas.save(new Moneda(1, "doblón español", 5.0, 6.77, "Oro", "Mojado"));
		repMonedas.save(new Moneda(6, "dolar", 1.3, 7.4, "Cobre", "Abollada"));
		repProveedor.save(new Proveedor("B0000000A", "Calderilla", "Calle Falsa 123", "correo@calderilla.dom", 972240765));
		repProveedor.save(new Proveedor("A12345678", "URJC", "Calle Tulipán S/N", "dineros@urjc.es", 912345678));
	}
		
	@RequestMapping("/")
	public String tablon(Model model) {
			
		model.addAttribute("monedas", repMonedas.findAll());

		return "index";
	}
	
}