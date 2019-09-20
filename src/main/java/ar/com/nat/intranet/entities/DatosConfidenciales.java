package ar.com.nat.intranet.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import ar.com.nat.intranet.repository.TipoDatosEnum;

@Entity
public class DatosConfidenciales {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotNull
	private int codTipoDato;
	@Transient
	private String tipoDato;
	@NotBlank @NotEmpty
	private String origenDato;
	@Lob @NotBlank @NotEmpty
	private String dato;
	@Temporal(TemporalType.DATE)
	private Date fechaAlta;
	@Temporal(TemporalType.DATE)
	private Date fechaModificacion;
	@Temporal(TemporalType.DATE)
	private Date fechaBaja;
	private Boolean activo;
	
	@PrePersist
	private void tipoDatoTOCodigo() {
		this.codTipoDato = TipoDatosEnum.busquedaByNombre(this.tipoDato).getCodTipoDato();
		this.fechaAlta = new Date();
	}
	@PreUpdate
	private void setFechaUpdate() {
		this.fechaModificacion = new Date();
	}
	@PostLoad
	private void codigoTOTipoDato() {
		this.tipoDato = TipoDatosEnum.busquedaByCodigo(this.codTipoDato).getTipoDato();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTipoDato() {
		return tipoDato;
	}
	public void setTipoDato(String tipoDato) {
		this.tipoDato = tipoDato;
	}
	public String getDato() {
		return dato;
	}
	public void setDato(String dato) {
		this.dato = dato;
	}
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public Date getFechaBaja() {
		return fechaBaja;
	}
	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public int getCodTipoDato() {
		return codTipoDato;
	}
	public void setCodTipoDato(int codTipoDato) {
		this.codTipoDato = codTipoDato;
	}
	public String getOrigenDato() {
		return origenDato;
	}
	public void setOrigenDato(String origenDato) {
		this.origenDato = origenDato;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	public Boolean getActivo() {
		return activo;
	}
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
}
