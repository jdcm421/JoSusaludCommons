package com.rimac.susalud.josusaludcommons.service;

import com.rimac.susalud.josusaludcommons.response.ResponseDTO;
import com.rimac.susalud.josusaludcommons.response.ResponseDatosMQ;
import com.rimac.susalud.josusaludcommons.response.ResponseParametroDet;

public interface ComunService {

	public ResponseDatosMQ obtenerDatosMQ();
	public ResponseDTO obtenerValorParametro(String parametro);
	public ResponseParametroDet obtenerSwitch();
	public String obtenerService();

}
