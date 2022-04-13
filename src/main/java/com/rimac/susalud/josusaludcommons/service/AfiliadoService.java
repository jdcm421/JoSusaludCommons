package com.rimac.susalud.josusaludcommons.service;

import java.sql.SQLException;

import com.rimac.susalud.josusaludcommons.model.In997RegafiUpdate;
import com.rimac.susalud.josusaludcommons.response.Response;
import com.rimac.susalud.josusaludcommons.response.ResponseAfiliadosSuSalud;
import com.rimac.susalud.josusaludcommons.response.ResponseObtenerAfiliados;


public interface AfiliadoService {

    public ResponseAfiliadosSuSalud obtenerAfiliadosEnvio(String filePropertiesName, String estadoAfiliado);

    public ResponseAfiliadosSuSalud obtenerAfiliadosCargaInicial(String filePropertiesName, String estadoAfiliado, String indicadorCargaInicial);

    public Response actualizarTramaAfiliado(String filePropertiesName, String idTrama, String estadoAfiliado);

    public ResponseObtenerAfiliados obtenerAfiliadosSuSalud(String filePropertiesName, String estadoTrama);

    public Response insertarSuSaludRespuesta(String filePropertiesName, String tramaestado, String indcargainicial, In997RegafiUpdate in997RegafiUpdate, byte[] msgId);

    public Response actualizarIdMessage(String filePropertiesName, String idTrama, byte[] idmessage);

    public Response obtenerIdmessageEnvio(String filePropertiesName, String estadoAfiliado);

}
