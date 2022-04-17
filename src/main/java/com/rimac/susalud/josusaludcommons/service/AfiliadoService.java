package com.rimac.susalud.josusaludcommons.service;

import com.rimac.susalud.josusaludcommons.model.In997RegafiUpdate;
import com.rimac.susalud.josusaludcommons.response.ResponseDTO;
import com.rimac.susalud.josusaludcommons.response.ResponseAfiliadosSuSalud;
import com.rimac.susalud.josusaludcommons.response.ResponseObtenerAfiliados;

public interface AfiliadoService {

    public ResponseObtenerAfiliados obtenerAfiliadosEnvio(String estadoAfiliado);

    public ResponseObtenerAfiliados obtenerAfiliadosCargaInicial(String estadoAfiliado, String indicadorCargaInicial);

    public ResponseDTO actualizarTramaAfiliado(String idTrama, String estadoAfiliado);

    public ResponseAfiliadosSuSalud obtenerAfiliadosSuSalud(String estadoTrama);

    public ResponseDTO insertarSuSaludRespuesta(String tramaestado, String indcargainicial, In997RegafiUpdate in997RegafiUpdate, byte[] msgId);

    public ResponseDTO actualizarIdMessage(String idTrama, byte[] idmessage);

    public ResponseDTO obtenerIdmessageEnvio(String estadoAfiliado);

}
