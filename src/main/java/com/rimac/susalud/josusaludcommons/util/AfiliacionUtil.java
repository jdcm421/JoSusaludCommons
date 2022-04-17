package com.rimac.susalud.josusaludcommons.util;

import com.rimac.susalud.josusaludcommons.model.In997RegafiUpdate;
import com.rimac.susalud.josusaludcommons.model.Trama997Bean;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.TreeMap;
import java.util.Vector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AfiliacionUtil {

    static Logger logger = LoggerFactory.getLogger(AfiliacionUtil.class);
    static protected HashMap<String, String> mapErrorDescripcion;
    static protected HashMap<String, String> mapErrorCampo;

    public static String readableFileSize(long size) {

        String fileSize = "";
        try {
            if (size <= 0) {
                fileSize = "0";
            }

            final String[] units = new String[]{"B", "KB", "MB", "GB", "TB"};
            int digitGroups = (int) (Math.log10(size) / Math.log10(1024));

            fileSize = (String) new DecimalFormat("#,##0.#").format(size / Math.pow(1024, digitGroups)) + " " + units[digitGroups];
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return fileSize;
    }

    public static String extraerRespuestaSuSalud(String tramaxml, String tag) {

        String cadena = "";
        try {
            String[] p = tramaxml.split(tag);
            String t = p[1];
            cadena = t.substring(1, t.length() - 2);
        } catch (Exception ex) {
            logger.error("error en obtener " + tag, ex);
        }

        return cadena;
    }

    protected static void leerArchivoCSV(String archivo, Map<String, String> mapa) throws Exception {

        BufferedReader reader = null;
        try {
            FileInputStream Fileinput = new FileInputStream(archivo);
            reader = new BufferedReader(new InputStreamReader(Fileinput));

            String line = "";
            while ((line = reader.readLine()) != null) {
                String[] campos = line.split(Constan.SEPARADOR);
                mapa.put(campos[0], campos[1]);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

//    public static Trama997Bean procesarTrama997(String trama, String id) throws Exception {
//        Trama997Bean bean = null;
//        try {
//            if (mapErrorCampo == null) {
//                mapErrorCampo = new HashMap<String, String>();
//                leerArchivoCSV(Constan.ERROR_CAMPO_CSV, mapErrorCampo);
//            }
//            if (mapErrorDescripcion == null) {
//                mapErrorDescripcion = new HashMap<String, String>();
//                leerArchivoCSV(Constan.ERROR_DESCRIPCION_CSV, mapErrorDescripcion);
//            }
//            String tramax12 = extraerRespuestaSuSalud(trama, Constan.TAG997);
//            RegafiUpdate997Service salida = new RegafiUpdate997ServiceImpl();
//            In997RegafiUpdate bo = salida.x12NToBean(tramax12);
//            bo.setFlag(true);
//            Vector<Vector<String>> dataVector = new Vector<Vector<String>>();
//            List<In997RegafiUpdateExcepcion> excepciones = bo.getDetallesExcepcion();
//
//            for (In997RegafiUpdateExcepcion ex : excepciones) {
//                Vector<String> fila = new Vector<String>();
//                String coCampoErr = ex.getCoCampoErr();
//                fila.add(coCampoErr);
//                fila.add(mapErrorCampo.get(coCampoErr));
//                fila.add(String.valueOf(ex.isFlagExcepcion())); //flag
//                String coDescripError = ex.getInCoErrorEncontrado();
//                fila.add(coDescripError);
//                fila.add(mapErrorDescripcion.get(coDescripError));
//                fila.add(ex.getPkAfiliado());
//                fila.add(ex.getPkAfiliadopkAfiliacion());
//                dataVector.add(fila);
//            }
//
//            bean = new Trama997Bean();
//            bean.setFeTransaccion(bo.getFeTransaccion());
//            bean.setHoTransaccion(bo.getHoTransaccion());
//            bean.setIdCorrelativo(bo.getIdCorrelativo());
//            bean.setIdReceptor(bo.getIdReceptor());
//            bean.setIdRemitente(bo.getIdRemitente());
//            bean.setIdTransaccion(bo.getIdTransaccion());
//            bean.setNoTransaccion(bean.getNoTransaccion());
//
//            bean.setNuControl(bo.getNuControl());
//            bean.setNuControlST(bean.getNuControlST());
//            bean.setNuControlST(trama);
//            bean.setNuControl(id);//msgid
//
//            bean.setExcepciones(dataVector);
//            bean.setDato(bo);
//        } catch (Exception e) {
//            throw e;
//        } finally {
//
//        }
//
//        return bean;
//    }
//
//    public static String CreateXML(String X12N) {
//
//        String xml = "<sus:Online271RegafiUpdateRequest xmlns:sus=\"http://www.susalud.gob.pe/Afiliacion/Online271RegafiUpdateRequest.xsd\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.susalud.gob.pe/Afiliacion/Online271RegafiUpdateRequest.xsd ../MsgSetProjOnline271RegafiUpdateRequest/importFiles/Online271RegafiUpdateRequest.xsd \">"
//                + "<txNombre>271_REGAFI_UPDATE</txNombre>"
//                + "<txPeticion>" + X12N + "</txPeticion></sus:Online271RegafiUpdateRequest>";
//
//        return xml.trim();
//    }
//
//    public static Properties loadFileProperties(String filePropertiesName) throws Exception {
//
//        Properties properties = null;
//        FileInputStream Fileinput = null;
//        try {
//            Fileinput = new FileInputStream(filePropertiesName);
//            if (Fileinput != null) {
//                properties = new Properties();
//                properties.load(Fileinput);
//            }
//        } catch (Exception e) {
//            throw e;
//        } finally {
//
//        }
//
//        return properties;
//    }
//
//    public static String evaluarRespuestaExcepciones(In997RegafiUpdate in997RegafiUpdate) {
//
//        String tramaEstadoRespuesta = Constan.TRAMA_ESTADO_RESPUESTA_RECIBIDO;
//
//        if (in997RegafiUpdate.getExcProceso() != null && !in997RegafiUpdate.getExcProceso().equals(Constan.VALIDACION_SUSALUD_OK_BD)) {
//            tramaEstadoRespuesta = Constan.TRAMA_ESTADO_RESPUESTA_OBSERVADO;
//        } else {
//            if (in997RegafiUpdate.getDetallesExcepcion() != null && in997RegafiUpdate.getDetallesExcepcion().size() > 0) {
//                for (In997RegafiUpdateExcepcion detalleExcepcion : in997RegafiUpdate.getDetallesExcepcion()) {
//                    if (detalleExcepcion.getExcBD() != null && !detalleExcepcion.getExcBD().equals(Constan.VALIDACION_SUSALUD_OK_BD)) {
//                        tramaEstadoRespuesta = Constan.TRAMA_ESTADO_RESPUESTA_OBSERVADO;
//                        break;
//                    }
//                }
//            }
//        }
//
//        return tramaEstadoRespuesta;
//    }
    public static String descripcionErrorServicioSuSalud(String codigoErrorSuSalud) {

        String descripcionError = "";

        if (codigoErrorSuSalud.equals(Constan.SERVICIO_SUSALUD_OK)) {
            descripcionError = "Todo correcto";
        } else if (codigoErrorSuSalud.equals(Constan.SERVICIO_SUSALUD_ERR_XML)) {
            descripcionError = "Estructura XML de entrada no corresponde a la definida";
        } else if (codigoErrorSuSalud.equals(Constan.SERVICIO_SUSALUD_ERR_SISTEMA)) {
            descripcionError = "Error ocurrido en el flujo de proceso";
        } else if (codigoErrorSuSalud.equals(Constan.SERVICIO_SUSALUD_ERR_ING_NOM_TRX)) {
            descripcionError = "No ingreso nombre de Transaccion";
        } else if (codigoErrorSuSalud.equals(Constan.SERVICIO_SUSALUD_ERR_NOMBRE_NO_EXISTE)) {
            descripcionError = "No existe el nombre de la transaccion";
        } else if (codigoErrorSuSalud.equals(Constan.SERVICIO_SUSALUD_ERR_NO_INGRESO_TRAMA)) {
            descripcionError = "No ingreso trama de Transaccion";
        }

        return descripcionError;
    }

    public static File crearArchivoAfiliados(TreeMap<Integer, String> listaRegistrosAfiliados, String iafa, String location) {

        SimpleDateFormat dateFormat = new SimpleDateFormat(Constan.SIMPLE_DATE_FORMAT);
        Date date = new Date();

        String filename = iafa + "_" + dateFormat.format(date);

        File fileout = new File(location + filename + Constan.EXTENSION_ARCHIVO_TEXTO);

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileout, true));

            Iterator<Entry<Integer, String>> iter = listaRegistrosAfiliados.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry<Integer, String> entry = iter.next();
                bw.write(entry.getValue());
                bw.newLine();
            }

            bw.close();

        } catch (FileNotFoundException ex) {
            logger.info("FileNotFoundException error");
            ex.printStackTrace();
        } catch (IOException ex) {
            logger.info("IOException error");
            ex.printStackTrace();
        }

        return fileout;
    }

    public static String obtenerFecha(String formatoFecha, Date date) {

        return new SimpleDateFormat(formatoFecha, Locale.US).format(date);

    }
}
