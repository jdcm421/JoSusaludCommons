package com.rimac.susalud.josusaludcommons.response;

public class Response {

	private Object data;
	private String mensaje;
	private String codigo;
	private String error;
	
	public Response(Object data, String mensaje, String codigo) {
		super();
		this.data = data;
		this.mensaje = mensaje;
		this.codigo = codigo;
	}
	
	public Response(String mensaje, String codigo, String error) {
		super();
		this.mensaje = mensaje;
		this.codigo = codigo;
		this.error = error;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
}
