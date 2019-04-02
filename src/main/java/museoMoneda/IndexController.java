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
		Moneda monedaEjemplo = new Moneda(1, "doblón español", 5.0, 6.77, "Oro", "Mojado");
		repMonedas.save(monedaEjemplo);
		Moneda m1 = new Moneda(2, "euro", 3.0, 7.4, "Estaño", "Oxidada");
		repMonedas.save(m1);
		Moneda m2 = new Moneda(6, "dolar", 1.3, 7.4, "Cobre", "Abollada");
		repMonedas.save(m2);
		repMonedas.save(new Moneda(6, "dolar", 1.3, 7.4, "Zinc", "Olorosa"));
		repMonedas.save(new Moneda(6, "yen", 2.0, 4, "Aluminio", "Reluciente"));
		repMonedas.save(new Moneda(17, "yen", 13.0, 7, "Bronce", "Doblada"));
		repMonedas.save(new Moneda(50, "dolar", 6.6, 1.4, "Plata", "Maravillosa"));
		
		Proveedor proveedorEjemplo = new Proveedor("B0000000A", "Calderilla", "Calle Falsa 123", "correo@calderilla.dom", 972240765);
		repProveedor.save(proveedorEjemplo);
		Proveedor p1 = new Proveedor("E2442019G", "Jarvis", "Quinta Avenida 890", "jarvis@ultron.mcu", 975640325);
		repProveedor.save(p1);
		Proveedor p2 = new Proveedor("A12345678", "URJC Mostoles", "Calle Tulipán S/N", "dineros@urjc.es", 912345678);
		repProveedor.save(p2);
		repProveedor.save(new Proveedor("B12345678", "URJC Vicalvaro", "Calle Rosas 67", "parne@urjc.es", 912345678));
		repProveedor.save(new Proveedor("C2135467Z", "AliBaba", "Calle Hortensia 143 2ºC", "ali@express.cn", 123456789));
		repProveedor.save(new Proveedor("D31256748", "Central Perk", "Centro Comercial Xanadu Local 46", "gunther@cperk.com", 876389076));

		repEjemplar.save(new Ejemplar(m1, 1967, "Frankfurt", Date.valueOf("1988-12-30"), "SC", p1));
		repEjemplar.save(new Ejemplar(m2, 1865, "Wakanda", Date.valueOf("1865-6-15"), "BC", p2));
		repEjemplar.save(new Ejemplar(monedaEjemplo, 1634, "Valladolid", Date.valueOf("2000-01-01"), "FDC", proveedorEjemplo));
		
	}
		
	@RequestMapping("/")
	public String tablon(Model model) {
			
		model.addAttribute("monedas", repMonedas.findAll());

		return "index";
	}
	
}