package museoMoneda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProveedorController {
	
	@Autowired
	public ProveedorRepository repProveedor;
	
	@RequestMapping("/insertar/proveedor")
	public String insertar(Proveedor proveedor, Model model) {
		if(! repProveedor.existsById(proveedor.getCif())){
			repProveedor.save(proveedor);
			model.addAttribute("mensaje", "Proveedor creado con Éxito.");
			return  "hecho";
		}else {
			model.addAttribute("error", "No se pudo añadir porque ya existe un proveedor con ese CIF.");
			return "error";
		}

	}
	@RequestMapping("/modificar/proveedor")
	public String modificar(@RequestParam String proveedorID, Model model) {
		
		String num = "proveedor";
		model.addAttribute("src",num);
		Proveedor proveedor = repProveedor.findById(proveedorID).get();
		model.addAttribute("proveedorID",proveedor);

		return "modificar";
	}
}
