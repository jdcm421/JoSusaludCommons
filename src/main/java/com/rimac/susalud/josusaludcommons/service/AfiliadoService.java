package com.rimac.susalud.josusaludcommons.service;

import java.sql.SQLException;

import org.springframework.stereotype.Service;
import com.rimac.susalud.josusaludcommons.model.In997RegafiUpdate;
import com.rimac.susalud.josusaludcommons.response.Response;

@Service
public interface AfiliadoService {

    public Response obtenerAfiliadosEnvio(String filePropertiesName, String estadoAfiliado) throws SQLException, Exception;
	
	public Response obtenerAfiliadosCargaInicial(String filePropertiesName, String estadoAfiliado, String indicadorCargaInicial) throws SQLException, Exception;
	
	public Response actualizarTramaAfiliado(String filePropertiesName, String idTrama, String estadoAfiliado) throws SQLException, Exception;

	public Response obtenerAfiliadosSuSalud(String filePropertiesName, String estadoTrama) throws SQLException, Exception;

	public Response insertarSuSaludRespuesta(String filePropertiesName, String tramaestado, String indcargainicial, In997RegafiUpdate afiliadoRpta, byte[] msgId) throws SQLException, Exception;

	public Response actualizarIdMessage(String filePropertiesName, String idTrama, byte[] idmessage) throws SQLException, Exception;

	public Response obtenerIdmessageEnvio(String filePropertiesName, String estadoAfiliado) throws SQLException, Exception;

}
