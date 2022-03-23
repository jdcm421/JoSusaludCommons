package com.rimac.susalud.josusaludcommons.service.impl;

import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.rimac.susalud.josusaludcommons.response.*;
import com.rimac.susalud.josusaludcommons.service.ComunService;

@Service
public class ComunServiceImpl implements ComunService {

	private static final Logger LOG = LoggerFactory.getLogger(ComunServiceImpl.class);

	@Override
	public Response obtenerDatosMQ(String filePropertiesName) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response obtenerValorParametro(String filePropertiesName, String parametro) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
