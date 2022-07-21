package com.rimac.susalud.josusaludcommons.response;

import com.rimac.susalud.josusaludcommons.model.ParametroDetalle;

public class ResponseParametroDet extends Response {
	private ParametroDetalle data;

	public ParametroDetalle getData() {
		return data;
	}

	public void setData(ParametroDetalle data) {
		this.data = data;
	}
}
