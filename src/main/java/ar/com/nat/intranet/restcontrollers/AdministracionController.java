package ar.com.nat.intranet.restcontrollers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import ar.com.nat.intranet.entities.DatosConfidenciales;
import ar.com.nat.intranet.exceptions.ViolationDataBaseRule;
import ar.com.nat.intranet.services.ControlDatosService;

@RestController
@RequestMapping("/admin")
//preauthorize ADM
public class AdministracionController {

	@Autowired
	ControlDatosService datosService;
	
	@PostMapping("/{tipo}")
	public ResponseEntity<String> guardaDatosConfidenciales(@Valid DatosConfidenciales datos,BindingResult result){
		try {
			datosService.saveDatosConfidenciales(datos);
			return ResponseEntity.ok().build();
		} catch (ViolationDataBaseRule e) {
			return ResponseEntity.badRequest().body("hubo un error en la requisicion");
		}
		
	}
	@PutMapping("/{tipo}")
	public ResponseEntity<String> guardaDatosConfidenciales1(@Valid DatosConfidenciales datos,BindingResult result){
		try {
			datosService.updateDatosConfidenciales(datos);
			return ResponseEntity.ok().build();
		} catch (ViolationDataBaseRule e) {
			return ResponseEntity.badRequest().body("hubo una falla en el envio de los datos del formulario");
		}
		
	}
}
