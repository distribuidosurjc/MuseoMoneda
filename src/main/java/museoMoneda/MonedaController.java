package museoMoneda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MonedaController {

	@Autowired
	public MonedaRepository repMonedas;


	@RequestMapping("/insertar/moneda")
	public String insertar(Moneda moneda, Model model) {
		String src = "moneda";
		model.addAttribute("src", src);
		repMonedas.save(moneda);

		return "hecho";
	}
	@RequestMapping("/modificar/moneda")
	public String modificar(@RequestParam int monedaID, Model model) {
		String num = "moneda";
		model.addAttribute("src", num);
		Moneda moneda = repMonedas.findById(monedaID).get();
		model.addAttribute("monedaID",moneda);
		
		return "modificar";
	}
	
}