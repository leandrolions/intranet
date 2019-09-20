package ar.com.nat.intranet.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.nat.intranet.entities.DatosConfidenciales;
import ar.com.nat.intranet.exceptions.ViolationDataBaseRule;
import ar.com.nat.intranet.repository.DatosRepository;

@Service
public class ControlDatosService {
	@Autowired
	DatosRepository datosRepo;
	
	public void saveDatosConfidenciales(DatosConfidenciales datos) throws ViolationDataBaseRule {
		if(datos.getId() == null) {
			datosRepo.save(datos);
		}else {
			throw new ViolationDataBaseRule("For save entity remove the id");
		}
	}
	
	public void updateDatosConfidenciales(DatosConfidenciales datos) throws ViolationDataBaseRule {
		if(Optional.ofNullable(datos.getId()).isPresent()) {
			datosRepo.save(datos);
		}else {
			throw new ViolationDataBaseRule("For update entity add the id");
		}
	}
}
