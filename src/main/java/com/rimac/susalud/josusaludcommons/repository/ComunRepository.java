package com.rimac.susalud.josusaludcommons.repository;

import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import com.rimac.susalud.josusaludcommons.model.DatosMQ;
import com.rimac.susalud.josusaludcommons.model.ParametroDetalle;
import javax.persistence.ParameterMode;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;

@Repository
public class ComunRepository {

    private static final Logger LOG = LoggerFactory.getLogger(ComunRepository.class);

    @Value("${procedimiento.obtenervaloresmq}")
    private String prodObtenerValoresMQ;

    @Value("${procedimiento.parametrovalor}")
    private String prodparametroValor;

    @Autowired
    EntityManager entityManager;

    public DatosMQ obtenerDatosMQ(String Schema) throws SQLException, Exception {
        DatosMQ datosMQ = new DatosMQ();
        try {
        	LOG.info("ESQUEMAS A CONSULTAR " + Schema);
            StoredProcedureQuery query = entityManager.createStoredProcedureQuery(Schema+"."+prodObtenerValoresMQ)
                    .registerStoredProcedureParameter(1, String.class, ParameterMode.OUT)
                    .registerStoredProcedureParameter(2, String.class, ParameterMode.OUT)
                    .registerStoredProcedureParameter(3, String.class, ParameterMode.OUT)
                    .registerStoredProcedureParameter(4, String.class, ParameterMode.OUT)
                    .registerStoredProcedureParameter(5, String.class, ParameterMode.OUT)
                    .registerStoredProcedureParameter(6, String.class, ParameterMode.OUT)
                    .registerStoredProcedureParameter(7, String.class, ParameterMode.OUT)
                    .registerStoredProcedureParameter(8, String.class, ParameterMode.OUT)
                    .registerStoredProcedureParameter(9, String.class, ParameterMode.OUT)
                    .registerStoredProcedureParameter(10, String.class, ParameterMode.OUT)
                    .registerStoredProcedureParameter(11, String.class, ParameterMode.OUT)
                    .registerStoredProcedureParameter(12, String.class, ParameterMode.OUT);
            query.execute();

            datosMQ.setPasswordMQ((String) query.getOutputParameterValue(1));
            datosMQ.setUserMQ((String) query.getOutputParameterValue(2));
            datosMQ.setQueueManager((String) query.getOutputParameterValue(3));
            datosMQ.setIpServerQueueManager((String) query.getOutputParameterValue(4));
            datosMQ.setPortServerQueueManager((String) query.getOutputParameterValue(5));
            datosMQ.setChannelMQ((String) query.getOutputParameterValue(6));
            datosMQ.setQueueRequest((String) query.getOutputParameterValue(7));
            datosMQ.setQueueResponse((String) query.getOutputParameterValue(8));
            datosMQ.setnRetry((String) query.getOutputParameterValue(9));
            datosMQ.settWaitinterval((String) query.getOutputParameterValue(10));
            datosMQ.setSenderActive((String) query.getOutputParameterValue(11));
            datosMQ.setReceiverActive((String) query.getOutputParameterValue(12));

        } catch (Exception ex) {
            LOG.error("Error Repository obtenerDatosMQ", ex);
            throw ex;
        }
        return datosMQ;
    }

    public String obtenerValorParametro(String parametro,String Schema) throws SQLException, Exception {
        String result = null;
        try{
        	LOG.info("ESQUEMAS A CONSULTAR " + Schema);
        	result = (String) entityManager.createNativeQuery(
        	        "SELECT "+Schema+"."+prodparametroValor+"(:ac_valor) FROM DUAL"
        		    ).setParameter("ac_valor", parametro).getSingleResult();

        }catch(Exception ex){
            LOG.error("Error Repository obtenerValorParametro", ex);
        }
        return result;
    }
    
    public ParametroDetalle obtenerSwitch(){
    	ParametroDetalle parametroDetalle = new ParametroDetalle();
    	try {
    		return entityManager.createQuery("SELECT pd FROM ParametroDetalle pd WHERE pd.ideConstante like 'CFG_CONSTANTE_JOB'", ParametroDetalle.class).getSingleResult();
    	}catch(Exception ex) {
    		LOG.error("Error en Metodo Obtener Switch ", ex);
    	}
    	return parametroDetalle;
    }

}
