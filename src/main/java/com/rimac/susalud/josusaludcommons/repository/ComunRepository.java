package com.rimac.susalud.josusaludcommons.repository;

import java.sql.SQLException;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.rimac.susalud.josusaludcommons.model.DatosMQ;

public class ComunRepository {
	
	private static final Logger LOG = LoggerFactory.getLogger(ComunRepository.class);

	@Value("${procedimiento.obtenervaloresmq}")
	private String prodObtenerValoresMQ;
	
	@Value("${procedimiento.parametrovalor}")
	private String prodparametroValor;
	
	@Autowired
    EntityManager entityManager;
	
	public DatosMQ obtenerDatosMQ(String filePropertiesName) throws SQLException, Exception {
		return null;
	}
	public String obtenerValorParametro(String filePropertiesName, String parametro) throws SQLException, Exception {
		return null;
	}

}
