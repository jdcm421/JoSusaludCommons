package com.rimac.susalud.josusaludcommons.service.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rimac.susalud.josusaludcommons.model.DatosMQ;
import com.rimac.susalud.josusaludcommons.repository.ComunRepository;
import com.rimac.susalud.josusaludcommons.response.ResponseDTO;
import com.rimac.susalud.josusaludcommons.response.ResponseDatosMQ;
import com.rimac.susalud.josusaludcommons.service.ComunService;
import com.rimac.susalud.josusaludcommons.util.Constan;

import org.springframework.http.HttpStatus;

@Service
public class ComunServiceImpl implements ComunService {

    private static final Logger LOG = LoggerFactory.getLogger(ComunServiceImpl.class);

    @Autowired
    ComunRepository comunRepository;

    @Override
    public ResponseDatosMQ obtenerDatosMQ() {
        ResponseDatosMQ responseDatosMQ = new ResponseDatosMQ();
        DatosMQ datosMQ = new DatosMQ();
        try{
            datosMQ = comunRepository.obtenerDatosMQ();
            if (datosMQ == null) {
                responseDatosMQ.setCodigo(HttpStatus.NO_CONTENT.toString());
                responseDatosMQ.setError(Constan.GET_SERVICE_REQUEST_ERROR);
                responseDatosMQ.setMensaje(null);
                responseDatosMQ.setObtenerDatosMQ(null);
                return responseDatosMQ;
            }

            responseDatosMQ.setCodigo(HttpStatus.OK.toString());
            responseDatosMQ.setMensaje(Constan.GET_SERVICE_REQUEST);
            responseDatosMQ.setError(null);
            responseDatosMQ.setObtenerDatosMQ(datosMQ);
        }catch(Exception ex){
            LOG.error("Error Servicio obtenerDatosMQ ", ex);
            responseDatosMQ.setCodigo(HttpStatus.INTERNAL_SERVER_ERROR.toString());
            responseDatosMQ.setMensaje("Error en el Servicio obtenerDatosMQ");
            responseDatosMQ.setError(ex.getMessage());
            return responseDatosMQ;
        }
        return responseDatosMQ;
    }

    @Override
    public ResponseDTO obtenerValorParametro(String parametro) {
        ResponseDTO responseDTO = new ResponseDTO();
        String resultado = null;
        try{
            resultado = comunRepository.obtenerValorParametro(parametro);
            if (resultado == null) {
                responseDTO.setCodigo(HttpStatus.NOT_IMPLEMENTED.toString());
                responseDTO.setError(Constan.GET_SERVICE_REQUEST_ERROR + parametro);
                responseDTO.setMensaje(null);
                return responseDTO;
            }
            responseDTO.setCodigo(HttpStatus.OK.toString());
            responseDTO.setError(null);
            responseDTO.setMensaje(Constan.GET_SERVICE_REQUEST);
            responseDTO.setData(resultado);
        }catch(Exception ex){
            LOG.error("Error Servicio obtenerValorParametro " + parametro, ex);
            responseDTO.setCodigo(HttpStatus.INTERNAL_SERVER_ERROR.toString());
            responseDTO.setMensaje("Error en el Servicio obtenerIdmessageEnvio");
            responseDTO.setError(ex.getMessage());
            return responseDTO;
        }
        return responseDTO;
    }
}
