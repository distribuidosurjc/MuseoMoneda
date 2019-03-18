package museoMoneda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MonedaController {

	@Autowired
	public MonedaRepository repMonedas;


	@RequestMapping("/insertar/moneda")
	public String insertar(Moneda moneda, Model model) {

			repMonedas.save(moneda);

		return "hecho";
	}
}