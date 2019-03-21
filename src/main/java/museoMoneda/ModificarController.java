package museoMoneda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

public class ModificarController {

	
	@Autowired
	public MonedaRepository repMonedas;
	
	@RequestMapping("/modificar/moneda/{id}")
	public String modificar(
			@PathVariable(value="id") int id,
			Model model) {
			Moneda moneda = repMonedas.findByModelo(id);
			// Moneda moneda = repMonedas.findById(id).get();
			model.addAttribute("moneda", moneda);
		return "Modificar";
	}
}
