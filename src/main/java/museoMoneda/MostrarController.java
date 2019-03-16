package museoMoneda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MostrarController {
	
	@Autowired
	public MonedaRepository repMonedas;

	@RequestMapping("/mostrar")
	public String mostrar(@RequestParam Integer modelo, Model model) {

		Moneda moneda = repMonedas.findById(modelo).get();
		
		model.addAttribute("moneda", moneda);

		return "mostrar";
	}
}