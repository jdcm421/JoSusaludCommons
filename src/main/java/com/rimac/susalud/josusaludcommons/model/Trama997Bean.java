package com.rimac.susalud.josusaludcommons.model;

import java.util.Vector;

public class Trama997Bean {
	
	private String feTransaccion;
	private String hoTransaccion;
	private String idCorrelativo;
	private String idReceptor;
	private String idRemitente;
	private String idTransaccion;
	private String nuControl;
	private String nuControlST;
	private Vector<Vector<String>> excepciones = new Vector<>();
	private In997RegafiUpdate dato;
	
	public String getFeTransaccion() {
		return feTransaccion;
	}
	public void setFeTransaccion(String feTransaccion) {
		this.feTransaccion = feTransaccion;
	}
	public String getHoTransaccion() {
		return hoTransaccion;
	}
	public void setHoTransaccion(String hoTransaccion) {
		this.hoTransaccion = hoTransaccion;
	}
	public String getIdCorrelativo() {
		return idCorrelativo;
	}
	public void setIdCorrelativo(String idCorrelativo) {
		this.idCorrelativo = idCorrelativo;
	}
	public String getIdReceptor() {
		return idReceptor;
	}
	public void setIdReceptor(String idReceptor) {
		this.idReceptor = idReceptor;
	}
	public String getIdRemitente() {
		return idRemitente;
	}
	public void setIdRemitente(String idRemitente) {
		this.idRemitente = idRemitente;
	}
	public String getIdTransaccion() {
		return idTransaccion;
	}
	public void setIdTransaccion(String idTransaccion) {
		this.idTransaccion = idTransaccion;
	}
	public String getNuControl() {
		return nuControl;
	}
	public void setNuControl(String nuControl) {
		this.nuControl = nuControl;
	}
	public String getNuControlST() {
		return nuControlST;
	}
	public void setNuControlST(String nuControlST) {
		this.nuControlST = nuControlST;
	}
	public Vector<Vector<String>> getExcepciones() {
		return excepciones;
	}
	public void setExcepciones(Vector<Vector<String>> excepciones) {
		this.excepciones = excepciones;
	}
	public In997RegafiUpdate getDato() {
		return dato;
	}
	public void setDato(In997RegafiUpdate dato) {
		this.dato = dato;
	}
	
	
}
