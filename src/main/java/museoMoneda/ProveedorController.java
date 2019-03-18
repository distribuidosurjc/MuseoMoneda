package museoMoneda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProveedorController {
	
	@Autowired
	public ProveedorRepository repProveedor;
	
	@RequestMapping("/insertar/proveedor")
	public String insertar(Proveedor proveedor, Model model) {

			repProveedor.save(proveedor);


		return "hecho";
	}
}
