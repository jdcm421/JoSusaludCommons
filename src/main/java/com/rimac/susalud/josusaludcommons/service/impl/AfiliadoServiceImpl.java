package com.rimac.susalud.josusaludcommons.service.impl;

import com.rimac.susalud.josusaludcommons.model.AfiliadoEnvio;
import com.rimac.susalud.josusaludcommons.model.AfiliadoRespuesta;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rimac.susalud.josusaludcommons.model.In997RegafiUpdate;
import com.rimac.susalud.josusaludcommons.repository.AfiliadoRepository;
import com.rimac.susalud.josusaludcommons.response.ResponseDTO;
import com.rimac.susalud.josusaludcommons.response.ResponseAfiliadosSuSalud;
import com.rimac.susalud.josusaludcommons.response.ResponseObtenerAfiliados;
import com.rimac.susalud.josusaludcommons.service.AfiliadoService;
import com.rimac.susalud.josusaludcommons.util.Constan;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import org.springframework.http.HttpStatus;

@Service
public class AfiliadoServiceImpl implements AfiliadoService {

    private static final Logger LOG = LoggerFactory.getLogger(AfiliadoServiceImpl.class);

    @Autowired
    AfiliadoRepository afiliadoRepository;

    @Override
    public ResponseObtenerAfiliados obtenerAfiliadosEnvio(String estadoAfiliado) {
        ResponseObtenerAfiliados responseObtenerAfiliados = new ResponseObtenerAfiliados();
        List<AfiliadoEnvio> servicios = new ArrayList<>();
        try {
            servicios = afiliadoRepository.obtenerAfiliadosEnvio(estadoAfiliado);
            if (servicios.isEmpty()) {
                responseObtenerAfiliados.setCodigo(HttpStatus.NO_CONTENT.toString());
                responseObtenerAfiliados.setError(Constan.GET_SERVICE_REQUEST_ERROR + estadoAfiliado);
                responseObtenerAfiliados.setMensaje(null);
                responseObtenerAfiliados.setAfiliados(null);
                return responseObtenerAfiliados;
            }

            responseObtenerAfiliados.setCodigo(HttpStatus.OK.toString());
            responseObtenerAfiliados.setMensaje(Constan.GET_SERVICE_REQUEST + estadoAfiliado);
            responseObtenerAfiliados.setError(null);
            responseObtenerAfiliados.setAfiliados(servicios);
        } catch (Exception e) {
            LOG.error("Error Servicio obtenerAfiliadosEnvio " + estadoAfiliado, e);
            responseObtenerAfiliados.setCodigo(HttpStatus.INTERNAL_SERVER_ERROR.toString());
            responseObtenerAfiliados.setMensaje("Error en el Servicio obtenerAfiliadosEnvio");
            responseObtenerAfiliados.setError(e.getMessage());
            return responseObtenerAfiliados;
        }
        return responseObtenerAfiliados;
    }

    @Override
    public ResponseObtenerAfiliados obtenerAfiliadosCargaInicial(String estadoAfiliado,
            String indicadorCargaInicial) {
        ResponseObtenerAfiliados responseObtenerAfiliados = new ResponseObtenerAfiliados();
        List<AfiliadoEnvio> servicios = new ArrayList<>();
        try {
            servicios = afiliadoRepository.obtenerAfiliadosCargaInicial(estadoAfiliado, indicadorCargaInicial);
            if (servicios.isEmpty()) {
                responseObtenerAfiliados.setCodigo(HttpStatus.NO_CONTENT.toString());
                responseObtenerAfiliados.setError(Constan.GET_SERVICE_REQUEST_ERROR + estadoAfiliado + indicadorCargaInicial);
                responseObtenerAfiliados.setMensaje(null);
                responseObtenerAfiliados.setAfiliados(null);
                return responseObtenerAfiliados;
            }

            responseObtenerAfiliados.setCodigo(HttpStatus.OK.toString());
            responseObtenerAfiliados.setMensaje(Constan.GET_SERVICE_REQUEST + estadoAfiliado + " "+ indicadorCargaInicial);
            responseObtenerAfiliados.setError(null);
            responseObtenerAfiliados.setAfiliados(servicios);
        } catch (Exception e) {
            LOG.error("Error Servicio obtenerAfiliadosCargaInicial " + estadoAfiliado + " " + indicadorCargaInicial, e);
            responseObtenerAfiliados.setCodigo(HttpStatus.INTERNAL_SERVER_ERROR.toString());
            responseObtenerAfiliados.setMensaje("Error en el Servicio obtenerAfiliadosCargaInicial");
            responseObtenerAfiliados.setError(e.getMessage());
            return responseObtenerAfiliados;
        }
        return responseObtenerAfiliados;
    }

    @Override
    public ResponseDTO actualizarTramaAfiliado(String idTrama, String estadoAfiliado) {
        ResponseDTO responseDTO = new ResponseDTO();
        HashMap<String, Object> resultado = new HashMap<>();
        boolean result = false;
        try {
            result = afiliadoRepository.actualizarTramaAfiliado(idTrama, estadoAfiliado);
            if (!result) {
                responseDTO.setCodigo(HttpStatus.NOT_IMPLEMENTED.toString());
                responseDTO.setError(Constan.PUT_SERVICE_REQUEST_ERROR + idTrama + " " + estadoAfiliado);
                responseDTO.setMensaje(null);
                return responseDTO;
            }

            resultado.put("idTrama ", idTrama);
            resultado.put("Estado Afiliado ", estadoAfiliado);
            responseDTO.setCodigo(HttpStatus.CREATED.toString());
            responseDTO.setError(null);
            responseDTO.setMensaje(Constan.PUT_SERVICE_REQUEST);
            responseDTO.setData(resultado);
        } catch (Exception e) {
            LOG.error("Error Servicio actualizarTramaAfiliado " + resultado.toString(), e);
            responseDTO.setCodigo(HttpStatus.INTERNAL_SERVER_ERROR.toString());
            responseDTO.setMensaje("Error en el Servicio actualizarTramaAfiliado");
            responseDTO.setError(e.getMessage());
            return responseDTO;
        }
        return responseDTO;
    }

    @Override
    public ResponseAfiliadosSuSalud obtenerAfiliadosSuSalud(String estadoTrama) {
        ResponseAfiliadosSuSalud responseAfiliadosSuSalud = new ResponseAfiliadosSuSalud();
        List<AfiliadoRespuesta> servicios = new ArrayList<>();
        try {
            servicios = afiliadoRepository.obtenerAfiliadosSuSalud(estadoTrama);
            if (servicios.isEmpty()) {
                responseAfiliadosSuSalud.setCodigo(HttpStatus.NO_CONTENT.toString());
                responseAfiliadosSuSalud.setError(Constan.GET_SERVICE_REQUEST_ERROR + estadoTrama);
                responseAfiliadosSuSalud.setMensaje(null);
                responseAfiliadosSuSalud.setObtenerAfiliadosSuSalud(null);
                return responseAfiliadosSuSalud;
            }

            responseAfiliadosSuSalud.setCodigo(HttpStatus.OK.toString());
            responseAfiliadosSuSalud.setMensaje(Constan.GET_SERVICE_REQUEST + estadoTrama);
            responseAfiliadosSuSalud.setError(null);
            responseAfiliadosSuSalud.setObtenerAfiliadosSuSalud(servicios);
        } catch (Exception e) {
            LOG.error("Error Servicio obtenerAfiliadosEnvio " + estadoTrama, e);
            responseAfiliadosSuSalud.setCodigo(HttpStatus.INTERNAL_SERVER_ERROR.toString());
            responseAfiliadosSuSalud.setMensaje("Error en el Servicio obtenerAfiliadosEnvio");
            responseAfiliadosSuSalud.setError(e.getMessage());
            return responseAfiliadosSuSalud;
        }
        return responseAfiliadosSuSalud;
    }

    @Override
    public ResponseDTO insertarSuSaludRespuesta(String tramaestado, String indcargainicial,
            In997RegafiUpdate afiliadoRpta, byte[] msgId) {
        ResponseDTO responseDTO = new ResponseDTO();
        HashMap<String, Object> resultado = new HashMap<>();
        boolean result = false;
        try {
            result = afiliadoRepository.insertarSuSaludRespuesta(tramaestado, indcargainicial, afiliadoRpta, msgId);
            if (!result) {
                responseDTO.setCodigo(HttpStatus.NOT_IMPLEMENTED.toString());
                responseDTO.setError(Constan.POST_SERVICE_REQUEST_ERROR);
                responseDTO.setMensaje(null);
                return responseDTO;
            }

            resultado.put("Trama estado", tramaestado);
            resultado.put("Indicar incial", indcargainicial);
            resultado.put("Afiliado RPTA", afiliadoRpta);
            resultado.put("Mesagge Id", msgId);
            responseDTO.setCodigo(HttpStatus.CREATED.toString());
            responseDTO.setError(null);
            responseDTO.setMensaje(Constan.POST_SERVICE_REQUEST);
            responseDTO.setData(resultado);
        } catch (Exception e) {
            LOG.error("Error Servicio insertarSuSaludRespuesta" + resultado.toString(), e);
            responseDTO.setCodigo(HttpStatus.INTERNAL_SERVER_ERROR.toString());
            responseDTO.setMensaje("Error en el Servicio insertarSuSaludRespuesta");
            responseDTO.setError(e.getMessage());
            return responseDTO;
        }
        return responseDTO;
    }

    @Override
    public ResponseDTO actualizarIdMessage(String idTrama, byte[] idmessage) {
        ResponseDTO responseDTO = new ResponseDTO();
        HashMap<String, Object> resultado = new HashMap<>();
        boolean result = false;
        try {
            result = afiliadoRepository.actualizarIdMessage(idTrama, idmessage);
            if (!result) {
                responseDTO.setCodigo(HttpStatus.NOT_IMPLEMENTED.toString());
                responseDTO.setError(Constan.PUT_SERVICE_REQUEST_ERROR);
                responseDTO.setMensaje(null);
                return responseDTO;
            }

            resultado.put("Trama estado", idTrama);
            resultado.put("Mesagge Id", idmessage);
            responseDTO.setCodigo(HttpStatus.CREATED.toString());
            responseDTO.setError(null);
            responseDTO.setMensaje(Constan.PUT_SERVICE_REQUEST);
            responseDTO.setData(resultado);
        } catch (Exception e) {
            LOG.error("Error Servicio actualizarIdMessage " + resultado.toString(), e);
            responseDTO.setCodigo(HttpStatus.INTERNAL_SERVER_ERROR.toString());
            responseDTO.setMensaje("Error en el Servicio actualizarIdMessage");
            responseDTO.setError(e.getMessage());
            return responseDTO;
        }
        return responseDTO;
    }

    @Override
    public ResponseDTO obtenerIdmessageEnvio(String estadoAfiliado) {
        ResponseDTO responseDTO = new ResponseDTO();
        TreeMap<Integer, byte[]> resultado = new TreeMap<>();
        try {
            resultado = afiliadoRepository.obtenerIdmessageEnvio(estadoAfiliado);
            if (resultado.isEmpty()) {
                responseDTO.setCodigo(HttpStatus.NOT_IMPLEMENTED.toString());
                responseDTO.setError(Constan.GET_SERVICE_REQUEST_ERROR + estadoAfiliado);
                responseDTO.setMensaje(null);
                return responseDTO;
            }
            responseDTO.setCodigo(HttpStatus.CREATED.toString());
            responseDTO.setError(null);
            responseDTO.setMensaje(Constan.GET_SERVICE_REQUEST);
            responseDTO.setData(resultado);
        } catch (Exception e) {
            LOG.error("Error Servicio obtenerIdmessageEnvio " + estadoAfiliado, e);
            responseDTO.setCodigo(HttpStatus.INTERNAL_SERVER_ERROR.toString());
            responseDTO.setMensaje("Error en el Servicio obtenerIdmessageEnvio");
            responseDTO.setError(e.getMessage());
            return responseDTO;
        }
        return responseDTO;
    }

}
