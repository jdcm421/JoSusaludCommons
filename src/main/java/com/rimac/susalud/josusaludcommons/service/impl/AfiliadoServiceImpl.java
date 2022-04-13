package com.rimac.susalud.josusaludcommons.service.impl;

import com.rimac.susalud.josusaludcommons.model.AfiliadoEnvio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rimac.susalud.josusaludcommons.model.In997RegafiUpdate;
import com.rimac.susalud.josusaludcommons.repository.AfiliadoRepository;
import com.rimac.susalud.josusaludcommons.response.Response;
import com.rimac.susalud.josusaludcommons.response.ResponseAfiliadosSuSalud;
import com.rimac.susalud.josusaludcommons.response.ResponseObtenerAfiliados;
import com.rimac.susalud.josusaludcommons.service.AfiliadoService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;

@Service
public class AfiliadoServiceImpl implements AfiliadoService {

    private static final Logger LOG = LoggerFactory.getLogger(AfiliadoServiceImpl.class);

    @Autowired
    AfiliadoRepository afiliadoRepository;

    @Override
    public ResponseAfiliadosSuSalud obtenerAfiliadosEnvio(String filePropertiesName, String estadoAfiliado) {
        ResponseAfiliadosSuSalud responseAfiliadosSuSalud = new ResponseAfiliadosSuSalud();
        List<AfiliadoEnvio> servicios = new ArrayList<>();
        try {
            servicios = afiliadoRepository.obtenerAfiliadosEnvio(filePropertiesName, estadoAfiliado);
            if (servicios.isEmpty()) {
                responseAfiliadosSuSalud.setCodigo(HttpStatus.NO_CONTENT.toString());
                responseAfiliadosSuSalud.setError("No se encontro los servicios solicitados");
                responseAfiliadosSuSalud.setMensaje(null);
                responseAfiliadosSuSalud.setObtenerAfiliadosSuSalud(null);
                return responseAfiliadosSuSalud;
            }

            responseAfiliadosSuSalud.setCodigo(HttpStatus.OK.toString());
            responseAfiliadosSuSalud.setMensaje("Se obtiene los servicios por el request " + estadoAfiliado);
            responseAfiliadosSuSalud.setError(null);
            responseAfiliadosSuSalud.setObtenerAfiliadosSuSalud(servicios);
        } catch (Exception e) {
            LOG.error("Error Servicio leerServicios", e);
            responseAfiliadosSuSalud.setCodigo(HttpStatus.INTERNAL_SERVER_ERROR.toString());
            responseAfiliadosSuSalud.setMensaje("Error en el Servicio leerServicios");
            responseAfiliadosSuSalud.setError(e.getMessage());
            return responseAfiliadosSuSalud;
        }
        return responseAfiliadosSuSalud;
    }

    @Override
    public ResponseAfiliadosSuSalud obtenerAfiliadosCargaInicial(String filePropertiesName, String estadoAfiliado,
            String indicadorCargaInicial) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Response actualizarTramaAfiliado(String filePropertiesName, String idTrama, String estadoAfiliado) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseObtenerAfiliados obtenerAfiliadosSuSalud(String filePropertiesName, String estadoTrama) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Response insertarSuSaludRespuesta(String filePropertiesName, String tramaestado, String indcargainicial,
            In997RegafiUpdate afiliadoRpta, byte[] msgId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Response actualizarIdMessage(String filePropertiesName, String idTrama, byte[] idmessage) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Response obtenerIdmessageEnvio(String filePropertiesName, String estadoAfiliado) {
        // TODO Auto-generated method stub
        return null;
    }

}
