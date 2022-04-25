package com.rimac.susalud.josusaludcommons.service;

import java.util.TreeMap;
import org.springframework.stereotype.Service;
import com.rimac.susalud.josusaludcommons.model.DatosMQ;
import com.rimac.susalud.josusaludcommons.response.Response;

@Service
public interface ConnectionMQ {

    public Response sendMessageSyn(TreeMap<Integer, String> mapListaEnvioMQ, DatosMQ datosMQ, Long hiloId);

    public Response getMessageSyn(TreeMap<Integer, byte[]> mapAfiliadosRespuestaEnvioMQ, DatosMQ datosMQ);
}
