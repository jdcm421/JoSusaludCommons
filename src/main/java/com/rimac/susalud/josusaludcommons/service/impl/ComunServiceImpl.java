package com.rimac.susalud.josusaludcommons.service.impl;

import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.rimac.susalud.josusaludcommons.model.DatosMQ;
import com.rimac.susalud.josusaludcommons.service.ComunService;

public class ComunServiceImpl implements ComunService {

	private static final Logger LOG = LoggerFactory.getLogger(ComunServiceImpl.class);
	
	@Override
	public DatosMQ obtenerDatosMQ(String filePropertiesName) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String obtenerValorParametro(String filePropertiesName, String parametro) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
