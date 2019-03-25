package museoMoneda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ModificarController {


	@Autowired
	public MonedaRepository repMonedas;

	/*	@RequestMapping("/modificar/{src}/{id}")
	public String modificar(
			@PathVariable(value="src") String src,
			@PathVariable(value="id") int id,
			Model model) {
		Moneda moneda = repMonedas.findById(id).get();
		model.addAttribute("moneda", moneda);
		return "Modificar";
	}*/

	@RequestMapping("/modificar/{src}")
	public String modificar(
			@PathVariable(value="src") String src,
			@RequestParam int monedaID,
			Model model) {
		
		model.addAttribute("monedaID", monedaID);

		return "modificar";
	}
}
