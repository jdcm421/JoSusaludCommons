package com.rimac.susalud.josusaludcommons.service;

import java.sql.SQLException;
import com.rimac.susalud.josusaludcommons.response.Response;
import com.rimac.susalud.josusaludcommons.response.ResponseAfiliadosSuSalud;
import com.rimac.susalud.josusaludcommons.response.ResponseObtenerAfiliados;

import pe.gob.susalud.jr.transaccion.susalud.bean.In997RegafiUpdate;

public interface AfiliadoService {

    public ResponseAfiliadosSuSalud obtenerAfiliadosEnvio(String filePropertiesName, String estadoAfiliado) throws SQLException, Exception;

    public ResponseAfiliadosSuSalud obtenerAfiliadosCargaInicial(String filePropertiesName, String estadoAfiliado, String indicadorCargaInicial) throws SQLException, Exception;

    public Response actualizarTramaAfiliado(String filePropertiesName, String idTrama, String estadoAfiliado) throws SQLException, Exception;

    public ResponseObtenerAfiliados obtenerAfiliadosSuSalud(String filePropertiesName, String estadoTrama) throws SQLException, Exception;

    public Response insertarSuSaludRespuesta(String filePropertiesName, String tramaestado, String indcargainicial, In997RegafiUpdate afiliadoRpta, byte[] msgId) throws SQLException, Exception;

    public Response actualizarIdMessage(String filePropertiesName, String idTrama, byte[] idmessage) throws SQLException, Exception;

    public Response obtenerIdmessageEnvio(String filePropertiesName, String estadoAfiliado) throws SQLException, Exception;

}
