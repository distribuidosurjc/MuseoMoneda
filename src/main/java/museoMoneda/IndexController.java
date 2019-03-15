package museoMoneda;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@Autowired
	public MonedaRepository repMonedas;
	
	@PostConstruct
	public void init() {
		repMonedas.save(new Moneda("001", 15, "euro", 1, 2, "Zinc", "Redonda"));
		repMonedas.save(new Moneda("002", 6, "dolar", 1.3, 7.4, "Cobre", "Abollada"));
	}
		
	@RequestMapping("/")
	public String tablon(Model model) {
			
		model.addAttribute("monedas", repMonedas.findAll());

		return "index";
	}

}