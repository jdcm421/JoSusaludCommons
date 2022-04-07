package com.rimac.susalud.josusaludcommons.repository;

import java.sql.SQLException;
import java.util.List;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rimac.susalud.josusaludcommons.model.*;
import com.rimac.susalud.josusaludcommons.service.impl.AfiliadoServiceImpl;

import pe.gob.susalud.jr.transaccion.susalud.bean.In997RegafiUpdate;

public class AfiliadoRepository {
	
	private static final Logger LOG = LoggerFactory.getLogger(AfiliadoRepository.class);


    public List<AfiliadoEnvio> obtenerAfiliadosEnvio(String filePropertiesName, String estadoAfiliado) throws SQLException, Exception {
		return null;
	}
	
	public List<AfiliadoEnvio> obtenerAfiliadosCargaInicial(String filePropertiesName, String estadoAfiliado, String indicadorCargaInicial) throws SQLException, Exception {
		return null;
	}
	
	public boolean actualizarTramaAfiliado(String filePropertiesName, String idTrama, String estadoAfiliado) throws SQLException, Exception {
		return false;
	}

	public List<AfiliadoRespuesta> obtenerAfiliadosSuSalud(String filePropertiesName, String estadoTrama) throws SQLException, Exception {
		return null;
	}

	public boolean insertarSuSaludRespuesta(String filePropertiesName, String tramaestado, String indcargainicial, In997RegafiUpdate afiliadoRpta, byte[] msgId) throws SQLException, Exception {
		return false;
	}

	public boolean actualizarIdMessage(String filePropertiesName, String idTrama, byte[] idmessage) throws SQLException, Exception {
		return false;
	}

	public TreeMap<Integer, byte[]> obtenerIdmessageEnvio(String filePropertiesName, String estadoAfiliado) throws SQLException, Exception {
		return null;
	}

}
