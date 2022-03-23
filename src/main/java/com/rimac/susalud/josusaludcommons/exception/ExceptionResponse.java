package com.rimac.susalud.josusaludcommons.exception;

import java.util.Date;

public class ExceptionResponse {

	private Date timestamp;
	private String mensajes;
	private String detalles;
	private Integer codigo;
	
	public ExceptionResponse(Date timestamp, String mensajes, String detalles, Integer codigo) {
		super();
		this.timestamp = timestamp;
		this.mensajes = mensajes;
		this.detalles = detalles;
		this.codigo = codigo;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getMensajes() {
		return mensajes;
	}
	public void setMensajes(String mensajes) {
		this.mensajes = mensajes;
	}
	public String getDetalles() {
		return detalles;
	}
	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
}
