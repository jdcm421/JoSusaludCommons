package com.rimac.susalud.josusaludcommons.service.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rimac.susalud.josusaludcommons.model.DatosMQ;
import com.rimac.susalud.josusaludcommons.model.ParametroDetalle;
import com.rimac.susalud.josusaludcommons.repository.ComunRepository;
import com.rimac.susalud.josusaludcommons.response.ResponseDTO;
import com.rimac.susalud.josusaludcommons.response.ResponseDatosMQ;
import com.rimac.susalud.josusaludcommons.response.ResponseParametroDet;
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
        String Schema = "";
        try{
        	Schema = obtenerService();
            datosMQ = comunRepository.obtenerDatosMQ(Schema);
            String consulta = Schema.equals(Constan.PKG_SUSALUD) ? Constan.BDSAS : Constan.BDRSA;
        	LOG.info("obtenerAfiliadosEnvio", consulta);
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
        String Schema = "";
        try{
        	Schema = obtenerService();
            resultado = comunRepository.obtenerValorParametro(parametro, Schema);
            String consulta = Schema.equals(Constan.PKG_SUSALUD) ? Constan.BDSAS : Constan.BDRSA;
        	LOG.info("obtenerAfiliadosEnvio", consulta);
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

	@Override
	public ResponseParametroDet obtenerSwitch() {
		ResponseParametroDet responseParametroDet = new ResponseParametroDet();
		ParametroDetalle detalle = new ParametroDetalle();
		try {
			detalle = comunRepository.obtenerSwitch();
			if(detalle == null) {
				responseParametroDet.setCodigo(HttpStatus.NO_CONTENT.toString());
				responseParametroDet.setMensaje(HttpStatus.NO_CONTENT.name());
				responseParametroDet.setError("No se obtiene el parametro de detalle");
			}
			responseParametroDet.setCodigo(HttpStatus.OK.toString());
			responseParametroDet.setMensaje("OK");
			responseParametroDet.setData(detalle);
		}catch (Exception e) {
			LOG.error("Error interno en servicio obtenerSwitch", e);
			responseParametroDet.setCodigo(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
			responseParametroDet.setMensaje("ERROR INTERNO");
			responseParametroDet.setError(e.getMessage());
			return responseParametroDet;
		}
		return responseParametroDet;
	}

	@Override
	public String obtenerService() {
		ParametroDetalle detalle = new ParametroDetalle();
		String query = "";
		try {
			detalle = comunRepository.obtenerSwitch();
			switch (detalle.getValor()) {
			case "N":
				query = Constan.PKG_SUSALUD_APP_EPS;
				break;

			default:
				query = Constan.PKG_SUSALUD;
				break;
			}
			LOG.info("ESQUEMA A CONSULTAR " + query);
		}catch (Exception e) {
			LOG.error("Error interno en servicio obtenerService", e);
		}
		return query;
	}
}
