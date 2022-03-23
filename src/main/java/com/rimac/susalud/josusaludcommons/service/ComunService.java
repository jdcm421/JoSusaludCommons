package com.rimac.susalud.josusaludcommons.service;

import java.sql.SQLException;

import com.rimac.susalud.josusaludcommons.model.DatosMQ;

public interface ComunService {

	public DatosMQ obtenerDatosMQ(String filePropertiesName) throws SQLException, Exception;
	public String obtenerValorParametro(String filePropertiesName, String parametro) throws SQLException, Exception;

}
