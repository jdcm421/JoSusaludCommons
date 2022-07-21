package com.rimac.susalud.josusaludcommons.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Entity(name="ParametroDetalle")
@Table(name = "CFG_CONSTANTE", schema = "APP_IAA_COMUNES")
@NoArgsConstructor
@AllArgsConstructor
public class ParametroDetalle {
	@Id
	@Column(name = "IDECONSTANTE")
	private String ideConstante;
	
	@Column(name = "DSCCONSTANTE")
	private String dsConstante;
	
	@Column(name = "IDPTIPODATO")
	private String idpTipoDato;
	
	@Column(name = "VALOR")
	private String valor;
	
	@Column(name = "VALORCLOB")
	private String valorClob;

	public String getIdeConstante() {
		return ideConstante;
	}

	public void setIdeConstante(String ideConstante) {
		this.ideConstante = ideConstante;
	}

	public String getDsConstante() {
		return dsConstante;
	}

	public void setDsConstante(String dsConstante) {
		this.dsConstante = dsConstante;
	}

	public String getIdpTipoDato() {
		return idpTipoDato;
	}

	public void setIdpTipoDato(String idpTipoDato) {
		this.idpTipoDato = idpTipoDato;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getValorClob() {
		return valorClob;
	}

	public void setValorClob(String valorClob) {
		this.valorClob = valorClob;
	}
}
