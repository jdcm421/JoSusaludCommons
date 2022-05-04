package com.rimac.susalud.josusaludcommons.service.impl;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
/*import com.ibm.mq.MQException;
import com.ibm.mq.MQGetMessageOptions;
import com.ibm.mq.MQMessage;
import com.ibm.mq.MQQueue;
import com.ibm.mq.MQQueueManager;
import com.ibm.mq.constants.CMQC;*/
import com.rimac.susalud.josusaludcommons.model.DatosMQ;
import com.rimac.susalud.josusaludcommons.model.In997RegafiUpdate;
import com.rimac.susalud.josusaludcommons.repository.AfiliadoRepository;
import com.rimac.susalud.josusaludcommons.repository.ComunRepository;
import com.rimac.susalud.josusaludcommons.response.Response;
import com.rimac.susalud.josusaludcommons.service.ConnectionMQ;
import com.rimac.susalud.josusaludcommons.service.RegafiUpdate997Service;
import com.rimac.susalud.josusaludcommons.util.AfiliacionUtil;
import com.rimac.susalud.josusaludcommons.util.Constan;
import java.util.HashMap;
//import org.apache.commons.codec.binary.Hex;

public class ConnectionMQImpl implements ConnectionMQ {

    private static final Logger LOG = LoggerFactory.getLogger(ConnectionMQImpl.class);

    @Autowired
    AfiliadoRepository afiliadoRepository;

    @Autowired
    ComunRepository comunRepository;

    @Override
    public Response sendMessageSyn(TreeMap<Integer, String> mapListaEnvioMQ, DatosMQ datosMQ,
            Long hiloId) {
        /*Response response = new Response();
        MQQueueManager queueManagerRimac = null;
        MQQueue queueRequestSuSalud = null;
        MQMessage messageSenderSuSaludMQ = null;

        try {
            //Thread.sleep(Integer.parseInt(datosMQ.gettWaitinterval()));
            //[INI] RTC-139711 / Pavel Quezada / 24-05-2018
            LOG.info("MQ Parameters: " + datosMQ.toString());
            HashMap<String, Object> hashProperties = seteoPropiedades(datosMQ);

            LOG.info("Connecting to queue manager " + datosMQ.getQueueManager() + " ...");
            queueManagerRimac = new MQQueueManager(datosMQ.getQueueManager(), hashProperties);
            LOG.info("done");

            LOG.info("Accessing queue: " + datosMQ.getQueueRequest() + " ...");
            queueRequestSuSalud = queueManagerRimac.accessQueue(datosMQ.getQueueRequest(), CMQC.MQOO_OUTPUT | CMQC.MQOO_FAIL_IF_QUIESCING);
            LOG.info("done");

            Iterator<Entry<Integer, String>> iterator = mapListaEnvioMQ.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, String> entry = iterator.next();
                String ideTrama = entry.getKey().toString();
                String tramaX12N = entry.getValue();
                boolean putMessageOK = true;
                try {
                    messageSenderSuSaludMQ = new MQMessage();
                    messageSenderSuSaludMQ.characterSet = Constan.CCSID_DEFAULT;
                    messageSenderSuSaludMQ.encoding = Constan.ENCODING_NATIVE;
                    messageSenderSuSaludMQ.format = CMQC.MQFMT_STRING;
                    messageSenderSuSaludMQ.expiry = CMQC.MQEI_UNLIMITED;

                    messageSenderSuSaludMQ.writeString(tramaX12N);

                    //PUT tramaX12N a la cola Request de SUSALUD
                    queueRequestSuSalud.put(messageSenderSuSaludMQ);
                } catch (Exception messageException) {
                    //[INI] RTC-142441 / Pavel Quezada / 12-06-2018
                    putMessageOK = false;
                    //[FIN] RTC-142441 / Pavel Quezada / 12-06-2018
                    LOG.error(messageException.getMessage());
                } finally {
                    if (putMessageOK) {
                        //Valida si imprime o no TramaX12N en archivos Logs
                        String imprimirTramaX12N = comunRepository.obtenerValorParametro(Constan.IMPRIMIR_TRAMA_X12N);

                        //Actualiza MsgId de MQ en la tabla de Envio
                        boolean updateMessageId = afiliadoRepository.actualizarIdMessage(ideTrama, messageSenderSuSaludMQ.messageId);

                        String msgId = new String(Hex.encodeHex(messageSenderSuSaludMQ.messageId)).toUpperCase();

                        if (imprimirTramaX12N.equals(Constan.ESTADO_BOOLEAN_TRUE)) {
                            LOG.info("hiloId: " + hiloId + " msgId: " + msgId + " idetrama: " + ideTrama + " tramaX12N: " + tramaX12N + " updateMessageId: " + updateMessageId);
                        } else {
                            LOG.info("hiloId: " + hiloId + " msgId: " + msgId + " idetrama: " + ideTrama + " updateMessageId: " + updateMessageId);
                        }
                    } else {
                        //Reestablece TramaEstado como Pendiente en la tabla de Envio
                        boolean reestablecerAPendiente = afiliadoRepository.actualizarTramaAfiliado(ideTrama, Constan.AFILIADO_PENDIENTE);
                        LOG.info("hiloId: " + hiloId + " idetrama: " + ideTrama + " error en PUT del mensaje, se reestablece a Pendiente: " + reestablecerAPendiente);
                    }
                }
            }
            //[FIN] RTC-139711 / Pavel Quezada / 24-05-2018
        } catch (MQException ex) {
            LOG.error(ex.getMessage());
        } catch (Exception ex) {
            LOG.error("sendMessageSyn: ", ex);
        } finally {
            if (messageSenderSuSaludMQ != null) {
                LOG.info("Clear message put");
                messageSenderSuSaludMQ.clearMessage();
            }
            if (queueRequestSuSalud != null) {
                LOG.info("Closing queueRequest " + queueRequestSuSalud.getName().trim() + " ...");
                queueRequestSuSalud.close();
            }
            if (queueManagerRimac != null) {
                LOG.info("Disconnecting from the Queue Manager " + queueManagerRimac.getName().trim() + " ...");
                queueManagerRimac.disconnect();
            }
        }*/
    	return new Response();
    }

    @Override
    public Response getMessageSyn(TreeMap<Integer, byte[]> mapAfiliadosRespuestaEnvioMQ,
            DatosMQ datosMQ) {
        Response response = new Response();
        /*int isContinuar = 0;
        //int numReIntentos = Integer.parseInt(datosMQ.getnRetry()); 
        int totalMensajesPendientes = mapAfiliadosRespuestaEnvioMQ.size();

        MQQueueManager queueManagerRimac = null;
        MQQueue queueResponseSuSalud = null;
        MQMessage messageRepliedSuSaludMQ = null;
        MQGetMessageOptions messageOptions = null;

        try {
            LOG.info("MQ Parameters: " + datosMQ.toString());
            HashMap<String, Object> hashProperties = seteoPropiedades(datosMQ);

            LOG.info("Connecting to queue manager " + datosMQ.getQueueManager() + " ...");
            queueManagerRimac = new MQQueueManager(datosMQ.getQueueManager(), hashProperties);
            LOG.info("done");

            messageOptions = new MQGetMessageOptions();
            messageOptions.matchOptions = CMQC.MQMO_MATCH_MSG_ID;
            messageOptions.options = CMQC.MQGMO_NO_SYNCPOINT; //Set no sync point
            messageOptions.options = CMQC.MQGMO_CONVERT; //Handles ASCII/EBCDIC
            messageOptions.options = CMQC.MQGMO_WAIT;//Wait until message arrives
            //messageOptions.waitInterval = Integer.parseInt(datosMQ.gettWaitinterval());

            LOG.info("Accessing queue: " + datosMQ.getQueueResponse() + " ...");
            queueResponseSuSalud = queueManagerRimac.accessQueue(datosMQ.getQueueResponse(), CMQC.MQOO_INPUT_AS_Q_DEF | CMQC.MQOO_FAIL_IF_QUIESCING);
            LOG.info("done");

            do {
                //Thread.sleep(Integer.parseInt(datosMQ.gettWaitinterval()));

                Iterator<Map.Entry<Integer, byte[]>> iterator = mapAfiliadosRespuestaEnvioMQ.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry<Integer, byte[]> entry = iterator.next();

                    String ideTrama = entry.getKey().toString();

                    messageRepliedSuSaludMQ = new MQMessage();
                    messageRepliedSuSaludMQ.characterSet = Constan.CCSID_DEFAULT;
                    messageRepliedSuSaludMQ.encoding = Constan.ENCODING_NATIVE;
                    messageRepliedSuSaludMQ.format = CMQC.MQFMT_STRING;
                    messageRepliedSuSaludMQ.messageId = entry.getValue();

                    //[INI] RTC-139711 / Pavel Quezada / 24-05-208
                    String msgId = new String(Hex.encodeHex(messageRepliedSuSaludMQ.messageId)).toUpperCase();
                    //LOG.info("getting msgId: " + msgId + " ideTrama: " + ideTrama);
                    try {
                        //GET message from SUSALUD Response Queue
                        queueResponseSuSalud.get(messageRepliedSuSaludMQ, messageOptions);
                    } catch (MQException ex) {
                        //LOG.error(ex);
                        LOG.error("MQException - " + ex.getMessage() + " ideTrama: " + ideTrama + " - msgId: " + msgId);
                    } finally {
                        iterator.remove();
                        isContinuar++;
                    }

                    if (messageRepliedSuSaludMQ.getDataLength() > 0) {
                        String msgDetail = messageRepliedSuSaludMQ.readStringOfByteLength(messageRepliedSuSaludMQ.getDataLength());
                        String codigoRptaServicioSuSalud = AfiliacionUtil.extraerRespuestaSuSalud(msgDetail, Constan.CODIGO_ERROR_SUSALUD);
                        String codigoRptaDescripcion = AfiliacionUtil.descripcionErrorServicioSuSalud(codigoRptaServicioSuSalud);

                        if (codigoRptaServicioSuSalud.equals(Constan.SERVICIO_SUSALUD_OK)) {
                            String tramaX12N = AfiliacionUtil.extraerRespuestaSuSalud(msgDetail, Constan.TAG997);
                            RegafiUpdate997Service regafiUpdate997Service = new RegafiUpdate997ServiceImpl();
                            In997RegafiUpdate in997RegafiUpdate = regafiUpdate997Service.x12NToBean(tramaX12N);

                            String tramaEstadoRpta = AfiliacionUtil.evaluarRespuestaExcepciones(in997RegafiUpdate);
                            //inserta respuesta de SuSalud
                            boolean insertRpta = afiliadoRepository.insertarSuSaludRespuesta(tramaEstadoRpta, Constan.CARGA_NORMAL, in997RegafiUpdate, messageRepliedSuSaludMQ.messageId);

                            //actualiza estado de Afiliado como Enviado
                            boolean updateAfiliado = afiliadoRepository.actualizarTramaAfiliado(ideTrama, Constan.AFILIADO_PROCESADO);

                            //Valida si imprime o no TramaX12N de respuesta en archivos Logs
                            String imprimirTramaX12N = comunRepository.obtenerValorParametro(Constan.IMPRIMIR_TRAMA_X12N);

                            if (imprimirTramaX12N.equals(Constan.ESTADO_BOOLEAN_TRUE)) {
                                LOG.info("get msgId: " + msgId + " ideTrama: " + ideTrama + " [respuesta susalud: " + codigoRptaServicioSuSalud + " - "
                                        + codigoRptaDescripcion + "] message: " + msgDetail + " [insertRpta: " + insertRpta + " - updateAfiliado: " + updateAfiliado + "]");
                            } else {
                                LOG.info("get msgId: " + msgId + " ideTrama: " + ideTrama + " [respuesta susalud: " + codigoRptaServicioSuSalud + " - "
                                        + codigoRptaDescripcion + "] [insertRpta: " + insertRpta + " - updateAfiliado: " + updateAfiliado + "]");
                            }

                        } else {
                            //actualiza estado de Afiliado como Error de Servicio SuSalud
                            boolean updateAfiliado = afiliadoRepository.actualizarTramaAfiliado(ideTrama, Constan.AFILIADO_ERROR_SERVICIO_SUSALUD);

                            LOG.error("get msgId: " + msgId + " ideTrama: " + ideTrama + " [error susalud: " + codigoRptaServicioSuSalud + " - "
                                    + codigoRptaDescripcion + "] message: " + msgDetail + " [updateAfiliado: " + updateAfiliado + "]");
                        }
                    }
                    //[FIN] RTC-139711 / Pavel Quezada / 24-05-208
                }
                //[INI] RTC-141326 / Pavel Quezada / 04-06-208
                //} while (isContinuar <= totalMensajesPendientes);
            } while (isContinuar < totalMensajesPendientes);
            //[FIN] RTC-141326 / Pavel Quezada / 04-06-208
        } catch (Exception ex) {
            LOG.error("getMessageSyn: ", ex);
        } finally {
            if (messageRepliedSuSaludMQ != null) {
                LOG.info("Clear message get");
                messageRepliedSuSaludMQ.clearMessage();
            }
            if (queueResponseSuSalud != null) {
                LOG.info("Closing queueResponse " + queueResponseSuSalud.getName().trim() + " ...");
                queueResponseSuSalud.close();
            }
            if (queueManagerRimac != null) {
                LOG.info("Disconnecting from the Queue Manager " + queueManagerRimac.getName().trim() + " ...");
                queueManagerRimac.disconnect();
            }
        }*/
        return response;
    }

    @SuppressWarnings("unused")
    private HashMap<String, Object> seteoPropiedades(DatosMQ datosMQ) {
        HashMap<String, Object> hashProperties = new HashMap<String, Object>();

        /*try {
            TripleDesUtil tripleDesUtil = new TripleDesUtil();

            String channelName = datosMQ.getChannelMQ();
            String hostName = datosMQ.getIpServerQueueManager();
            int port = Integer.parseInt(datosMQ.getPortServerQueueManager());
            String userid = datosMQ.getUserMQ();
            String password = tripleDesUtil.desencripta(datosMQ.getPasswordMQ());

            hashProperties.put(CMQC.CHANNEL_PROPERTY, channelName);
            hashProperties.put(CMQC.PORT_PROPERTY, port);
            hashProperties.put(CMQC.HOST_NAME_PROPERTY, hostName);
            hashProperties.put(CMQC.USER_ID_PROPERTY, userid);
            hashProperties.put(CMQC.PASSWORD_PROPERTY, password);
            hashProperties.put(CMQC.APPNAME_PROPERTY, "Registro Online Afiliados RIMAC - SUSALUD v1.0");
            hashProperties.put(CMQC.TRANSPORT_PROPERTY, CMQC.TRANSPORT_MQSERIES_CLIENT);
        } catch (Exception ex) {
            LOG.error("Exception: ", ex);
        }*/

        return hashProperties;
    }
    	
}
