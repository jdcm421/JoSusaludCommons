package com.rimac.susalud.josusaludcommons.service.impl;

import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.rimac.susalud.josusaludcommons.model.In997RegafiUpdate;
import com.rimac.susalud.josusaludcommons.response.Response;
import com.rimac.susalud.josusaludcommons.service.AfiliadoService;

public class AfiliadoServiceImpl implements AfiliadoService {

	private static final Logger LOG = LoggerFactory.getLogger(AfiliadoServiceImpl.class);
	
	
	@Override
	public Response obtenerAfiliadosEnvio(String filePropertiesName, String estadoAfiliado)
			throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response obtenerAfiliadosCargaInicial(String filePropertiesName, String estadoAfiliado,
			String indicadorCargaInicial) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response actualizarTramaAfiliado(String filePropertiesName, String idTrama, String estadoAfiliado)
			throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response obtenerAfiliadosSuSalud(String filePropertiesName, String estadoTrama)
			throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response insertarSuSaludRespuesta(String filePropertiesName, String tramaestado, String indcargainicial,
			In997RegafiUpdate afiliadoRpta, byte[] msgId) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response actualizarIdMessage(String filePropertiesName, String idTrama, byte[] idmessage)
			throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response obtenerIdmessageEnvio(String filePropertiesName, String estadoAfiliado)
			throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
