package museoMoneda;

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
	
	@RequestMapping("/insertar/{src}")
	public String insertar(@PathVariable(value="src") String src,
			Moneda moneda,Proveedor proveedor, Model model) {
		if(src == "moneda") {
			repMonedas.save(moneda);
		}else if(src == "proveedor"){
			repProveedor.save(proveedor);
		}
		
		
		
		
		return "hecho";
	}

}