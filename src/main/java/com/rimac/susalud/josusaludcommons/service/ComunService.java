package com.rimac.susalud.josusaludcommons.service;

import java.sql.SQLException;
import com.rimac.susalud.josusaludcommons.response.Response;

public interface ComunService {

	public Response obtenerDatosMQ(String filePropertiesName) throws SQLException, Exception;
	public Response obtenerValorParametro(String filePropertiesName, String parametro) throws SQLException, Exception;

}
