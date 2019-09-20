package ar.com.nat.intranet.repository;

import java.util.Arrays;

public enum TipoDatosEnum {

	contrasenas(1,"contrasenas"),
	archivos(2,"archivos"),
	personal(3,"persona"),
	patron(4,"patron");
	
	
	private final int codTipoDato;
	private final String tipoDato;
	
	
	private TipoDatosEnum(int codTipoDato, String tipoDato) {
		this.codTipoDato = codTipoDato;
		this.tipoDato = tipoDato;
	}

	public int getCodTipoDato() {
		return codTipoDato;
	}

	public String getTipoDato() {
		return tipoDato;
	}
	
	public static TipoDatosEnum busquedaByNombre(String tipoDato) {
		return Arrays.asList(TipoDatosEnum.values())
				.stream()
				.filter(t -> t.tipoDato.equalsIgnoreCase(tipoDato))
				.findFirst()
				.orElse(TipoDatosEnum.patron);
	}
	public static TipoDatosEnum busquedaByCodigo(int codDato) {
		return Arrays.asList(TipoDatosEnum.values())
				.stream()
				.filter(t -> t.codTipoDato == codDato)
				.findFirst()
				.orElse(TipoDatosEnum.patron);
	}

}
