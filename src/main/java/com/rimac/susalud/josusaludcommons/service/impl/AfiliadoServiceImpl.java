package com.rimac.susalud.josusaludcommons.service.impl;

import com.rimac.susalud.josusaludcommons.model.AfiliadoEnvio;
import com.rimac.susalud.josusaludcommons.model.AfiliadoRespuesta;

import org.apache.tomcat.util.bcel.Const;
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
import com.rimac.susalud.josusaludcommons.service.ComunService;
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
    
    @Autowired
    ComunService comunService;

    @Override
    public ResponseObtenerAfiliados obtenerAfiliadosEnvio(String estadoAfiliado) {
        ResponseObtenerAfiliados responseObtenerAfiliados = new ResponseObtenerAfiliados();
        List<AfiliadoEnvio> servicios = new ArrayList<>();
        String Schema = "";
        String consulta = "";
        try {
        	Schema = comunService.obtenerService();
        	LOG.info("Schema a consultar es " + Schema);
        	LOG.info("obtenerAfiliadosEnvio", estadoAfiliado);
        	consulta = Schema.equals(Constan.PKG_SUSALUD) ? Constan.BDSAS : Constan.BDRSA;
        	LOG.info("obtenerAfiliadosCargaInicial " + consulta);
            servicios = afiliadoRepository.obtenerAfiliadosEnvio(estadoAfiliado, Schema);
            if (servicios.isEmpty()) {
                responseObtenerAfiliados.setCodigo(HttpStatus.NO_CONTENT.toString());
                responseObtenerAfiliados.setError(Constan.GET_SERVICE_REQUEST_ERROR + estadoAfiliado+" "+ consulta);
                responseObtenerAfiliados.setMensaje(null);
                responseObtenerAfiliados.setAfiliados(null);
                LOG.warn("Atencion no se obtuvo datos obtenerAfiliadosEnvio", responseObtenerAfiliados, servicios);
                return responseObtenerAfiliados;
            }

            responseObtenerAfiliados.setCodigo(HttpStatus.OK.toString());
            responseObtenerAfiliados.setMensaje(Constan.GET_SERVICE_REQUEST + estadoAfiliado+" "+ consulta);
            responseObtenerAfiliados.setError(null);
            responseObtenerAfiliados.setAfiliados(servicios);
        } catch (Exception e) {
            LOG.error("Error Servicio obtenerAfiliadosEnvio " + estadoAfiliado, e);
            responseObtenerAfiliados.setCodigo(HttpStatus.INTERNAL_SERVER_ERROR.toString());
            responseObtenerAfiliados.setMensaje("Error en el Servicio obtenerAfiliadosEnvio" +" "+ consulta);
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
        String Schema = "";
        String consulta = "";
        try {
        	Schema = comunService.obtenerService();
        	LOG.info("Schema a consultar es " + Schema);
            servicios = afiliadoRepository.obtenerAfiliadosCargaInicial(estadoAfiliado, indicadorCargaInicial, Schema);
            consulta = Schema.equals(Constan.PKG_SUSALUD) ? Constan.BDSAS : Constan.BDRSA;
        	LOG.info("obtenerAfiliadosCargaInicial " + consulta);
            if (servicios.isEmpty()) {
                responseObtenerAfiliados.setCodigo(HttpStatus.NO_CONTENT.toString());
                responseObtenerAfiliados.setError(Constan.GET_SERVICE_REQUEST_ERROR + estadoAfiliado + indicadorCargaInicial +" "+ consulta);
                responseObtenerAfiliados.setMensaje(null);
                responseObtenerAfiliados.setAfiliados(null);
                return responseObtenerAfiliados;
            }

            responseObtenerAfiliados.setCodigo(HttpStatus.OK.toString());
            responseObtenerAfiliados.setMensaje(Constan.GET_SERVICE_REQUEST + estadoAfiliado + " "+ indicadorCargaInicial +" "+ consulta);
            responseObtenerAfiliados.setError(null);
            responseObtenerAfiliados.setAfiliados(servicios);
        } catch (Exception e) {
            LOG.error("Error Servicio obtenerAfiliadosCargaInicial " + estadoAfiliado + " " + indicadorCargaInicial, e);
            responseObtenerAfiliados.setCodigo(HttpStatus.INTERNAL_SERVER_ERROR.toString());
            responseObtenerAfiliados.setMensaje("Error en el Servicio obtenerAfiliadosCargaInicial"+" "+ consulta);
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
        String Schema = "";
        String consulta = "";
        try {
        	Schema = comunService.obtenerService();
        	LOG.info("Schema a consultar es " + Schema);
        	consulta = Schema.equals(Constan.PKG_SUSALUD) ? Constan.BDSAS : Constan.BDRSA;
        	LOG.info("obtenerAfiliadosCargaInicial " + consulta);
            result = afiliadoRepository.actualizarTramaAfiliado(idTrama, estadoAfiliado, Schema);
           
            if (!result) {
                responseDTO.setCodigo(HttpStatus.NOT_IMPLEMENTED.toString());
                responseDTO.setError(Constan.PUT_SERVICE_REQUEST_ERROR + idTrama + " " + estadoAfiliado+" "+ consulta);
                responseDTO.setMensaje(null);
                return responseDTO;
            }

            resultado.put("idTrama ", idTrama);
            resultado.put("Estado Afiliado ", estadoAfiliado);
            responseDTO.setCodigo(HttpStatus.CREATED.toString());
            responseDTO.setError(null);
            responseDTO.setMensaje(Constan.PUT_SERVICE_REQUEST +" "+ consulta);
            responseDTO.setData(resultado);
        } catch (Exception e) {
            LOG.error("Error Servicio actualizarTramaAfiliado " + resultado.toString(), e);
            responseDTO.setCodigo(HttpStatus.INTERNAL_SERVER_ERROR.toString());
            responseDTO.setMensaje("Error en el Servicio actualizarTramaAfiliado"+" "+ consulta);
            responseDTO.setError(e.getMessage());
            return responseDTO;
        }
        return responseDTO;
    }

    @Override
    public ResponseAfiliadosSuSalud obtenerAfiliadosSuSalud(String estadoTrama) {
        ResponseAfiliadosSuSalud responseAfiliadosSuSalud = new ResponseAfiliadosSuSalud();
        List<AfiliadoRespuesta> servicios = new ArrayList<>();
        String Schema = "";
        String consulta = "";
        try {
        	Schema = comunService.obtenerService();
        	LOG.info("Schema a consultar es " + Schema);
            servicios = afiliadoRepository.obtenerAfiliadosSuSalud(estadoTrama, Schema);
            consulta = Schema.equals(Constan.PKG_SUSALUD) ? Constan.BDSAS : Constan.BDRSA;
        	LOG.info("obtenerAfiliadosCargaInicial " + consulta);
            if (servicios.isEmpty()) {
                responseAfiliadosSuSalud.setCodigo(HttpStatus.NO_CONTENT.toString());
                responseAfiliadosSuSalud.setError(Constan.GET_SERVICE_REQUEST_ERROR + estadoTrama+" "+ consulta);
                responseAfiliadosSuSalud.setMensaje(null);
                responseAfiliadosSuSalud.setObtenerAfiliadosSuSalud(null);
                return responseAfiliadosSuSalud;
            }

            responseAfiliadosSuSalud.setCodigo(HttpStatus.OK.toString());
            responseAfiliadosSuSalud.setMensaje(Constan.GET_SERVICE_REQUEST + estadoTrama+" "+ consulta);
            responseAfiliadosSuSalud.setError(null);
            responseAfiliadosSuSalud.setObtenerAfiliadosSuSalud(servicios);
        } catch (Exception e) {
            LOG.error("Error Servicio obtenerAfiliadosEnvio " + estadoTrama, e);
            responseAfiliadosSuSalud.setCodigo(HttpStatus.INTERNAL_SERVER_ERROR.toString());
            responseAfiliadosSuSalud.setMensaje("Error en el Servicio obtenerAfiliadosEnvio"+" "+ consulta);
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
        String Schema = "";
        String consulta = "";
        try {
        	Schema = comunService.obtenerService();
        	LOG.info("Schema a consultar es " + Schema);
            result = afiliadoRepository.insertarSuSaludRespuesta(tramaestado, indcargainicial, afiliadoRpta, msgId, Schema);
            consulta = Schema.equals(Constan.PKG_SUSALUD) ? Constan.BDSAS : Constan.BDRSA;
        	LOG.info("obtenerAfiliadosCargaInicial " + consulta);
            if (!result) {
                responseDTO.setCodigo(HttpStatus.NOT_IMPLEMENTED.toString());
                responseDTO.setError(Constan.POST_SERVICE_REQUEST_ERROR+" "+ consulta);
                responseDTO.setMensaje(null);
                return responseDTO;
            }

            resultado.put("Trama estado", tramaestado);
            resultado.put("Indicar incial", indcargainicial);
            resultado.put("Afiliado RPTA", afiliadoRpta);
            resultado.put("Mesagge Id", msgId);
            responseDTO.setCodigo(HttpStatus.CREATED.toString());
            responseDTO.setError(null);
            responseDTO.setMensaje(Constan.POST_SERVICE_REQUEST +" "+ consulta);
            responseDTO.setData(resultado);
        } catch (Exception e) {
            LOG.error("Error Servicio insertarSuSaludRespuesta" + resultado.toString(), e);
            responseDTO.setCodigo(HttpStatus.INTERNAL_SERVER_ERROR.toString());
            responseDTO.setMensaje("Error en el Servicio insertarSuSaludRespuesta"+" "+ consulta);
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
        String Schema = "";
        String consulta = "";
        try {
        	Schema = comunService.obtenerService();
        	LOG.info("Schema a consultar es " + Schema);
            result = afiliadoRepository.actualizarIdMessage(idTrama, idmessage,Schema);
            consulta = Schema.equals(Constan.PKG_SUSALUD) ? Constan.BDSAS : Constan.BDRSA;
        	LOG.info("obtenerAfiliadosCargaInicial " + consulta);
            if (!result) {
                responseDTO.setCodigo(HttpStatus.NOT_IMPLEMENTED.toString());
                responseDTO.setError(Constan.PUT_SERVICE_REQUEST_ERROR+" "+ consulta);
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
            responseDTO.setMensaje("Error en el Servicio actualizarIdMessage"+" "+ consulta);
            responseDTO.setError(e.getMessage());
            return responseDTO;
        }
        return responseDTO;
    }

    @Override
    public ResponseDTO obtenerIdmessageEnvio(String estadoAfiliado) {
        ResponseDTO responseDTO = new ResponseDTO();
        TreeMap<Integer, byte[]> resultado = new TreeMap<>();
        String Schema = "";
        String consulta = "";
        try {
        	Schema = comunService.obtenerService();
        	LOG.info("Schema a consultar es " + Schema);
            resultado = afiliadoRepository.obtenerIdmessageEnvio(estadoAfiliado,Schema);
            consulta = Schema.equals(Constan.PKG_SUSALUD) ? Constan.BDSAS : Constan.BDRSA;
        	LOG.info("obtenerAfiliadosCargaInicial " + consulta);
            if (resultado.isEmpty()) {
                responseDTO.setCodigo(HttpStatus.NOT_IMPLEMENTED.toString());
                responseDTO.setError(Constan.GET_SERVICE_REQUEST_ERROR + estadoAfiliado+" "+ consulta);
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
            responseDTO.setMensaje("Error en el Servicio obtenerIdmessageEnvio"+" "+ consulta);
            responseDTO.setError(e.getMessage());
            return responseDTO;
        }
        return responseDTO;
    }

}
