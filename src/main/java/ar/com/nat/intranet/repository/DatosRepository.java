package ar.com.nat.intranet.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.nat.intranet.entities.DatosConfidenciales;

public interface DatosRepository extends JpaRepository<DatosConfidenciales, Long>{

	Optional<List<DatosConfidenciales>> findByCodTipoDato(int codTipoDato);
	
}
