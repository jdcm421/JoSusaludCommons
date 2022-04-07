package com.rimac.susalud.josusaludcommons.response;

import java.util.List;

import com.rimac.susalud.josusaludcommons.model.AfiliadoEnvio;

public class ResponseObtenerAfiliados extends Response {
	private List<AfiliadoEnvio> afiliados;

	public List<AfiliadoEnvio> getAfiliados() {
		return afiliados;
	}

	public void setAfiliados(List<AfiliadoEnvio> afiliados) {
		this.afiliados = afiliados;
	}
}
