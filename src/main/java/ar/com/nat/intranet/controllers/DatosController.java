package ar.com.nat.intranet.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vos")
public class DatosController {

	@RequestMapping
	public String retornaPantallaInicial(Model model) {
		return "inicial-page";
		
	}

}
