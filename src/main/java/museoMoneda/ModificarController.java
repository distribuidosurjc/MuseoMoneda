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

	@RequestMapping("/modificar/moneda")
	public String modificar(@RequestParam int monedaID, Model model) {
		String num = "moneda";
		model.addAttribute("src", num);
		Moneda moneda = repMonedas.findById(monedaID).get();
		model.addAttribute("moneda",moneda);

		return "modificar";
	}

	@RequestMapping("/actualizar/moneda")
	public String actualizar(@RequestParam int monedaID, Moneda moneda, Model model) {
		Moneda monedaAntigua = repMonedas.findById(monedaID).get();
		//model.addAttribute("error", monedaAntigua.getDescripcion());
		monedaAntigua.actualizar(moneda);
		repMonedas.save(monedaAntigua);
		moneda = null;
		return "hecho";
	}

}
