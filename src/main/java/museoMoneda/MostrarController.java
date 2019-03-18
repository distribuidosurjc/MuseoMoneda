package museoMoneda;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MostrarController {
	
	@Autowired
	public MonedaRepository repMonedas;
	public ProveedorRepository repProveedor;

	@RequestMapping("/buscar/{src}")
	public String buscar(
			@PathVariable(value="src") String src,
			Model model) {
		return "buscarYmostrar";
	}
	@RequestMapping("/buscar/{src}/{av}/mon")
	public String buscadoMoneda(
			@PathVariable(value="src") String src,
			@PathVariable(value="av") String av,
			String divisa, int valor,  Model model) {
		
		System.out.println(Integer.toString(valor));
		
		model.addAttribute("monedas", repMonedas.findByDivisa(divisa));
		
		return "buscarYmostrar";
	}
	@RequestMapping("/buscar/{src}/{av}/pro")
	public String buscadoProveedor(
			@PathVariable(value="src") String src,
			@PathVariable(value="av") String av,
			String nombre, Model model) {

		
		model.addAttribute("proveedores", repProveedor.findByNombre(nombre));
		
		return "buscarYmostrar";
	}
}