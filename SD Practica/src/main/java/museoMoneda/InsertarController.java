package museoMoneda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InsertarController {

	@Autowired
	public MonedaRepository repMonedas;

	@RequestMapping("/insertar/{src}")
	public String insertar(@PathVariable(value="src") String src,
			Moneda moneda, Model model) {

		repMonedas.save(moneda);

		return "hecho";
	}
}