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

	@RequestMapping("/buscar")
	public String buscar(Model model) {
		return "buscarYmostrar";
	}
	@RequestMapping("/buscar/{src}")
	public String buscado(
			@PathVariable(value="src") String src,
			String divisa, Model model) {

		
		model.addAttribute("monedas", repMonedas.findByDivisa(divisa));
		
		return "buscarYmostrar";
	}
}