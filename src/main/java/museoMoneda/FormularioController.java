package museoMoneda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FormularioController {

	@Autowired
	public MonedaRepository repMonedas;

	@RequestMapping("/crear/{src}")
	public String crear(
			@PathVariable(value="src") String src,
			Model model) {

		return "crear";
	}
	
}