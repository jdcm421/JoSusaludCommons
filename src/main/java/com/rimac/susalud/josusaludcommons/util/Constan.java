package com.rimac.susalud.josusaludcommons.util;

public class Constan {

    //Trama Estados para la tabla de Envio
    public static final String AFILIADO_PENDIENTE = "1";
    public static final String AFILIADO_EN_PROCESO = "2";
    public static final String AFILIADO_PROCESADO = "3";
    public static final String AFILIADO_ERROR_LIBRERIA_SUSALUD = "4";
    public static final String AFILIADO_ERROR_SERVICIO_SUSALUD = "5";

    //Trama Estados para la tabla de Respuesta
    public static final String TRAMA_ESTADO_RESPUESTA_RECIBIDO = "1";
    public static final String TRAMA_ESTADO_RESPUESTA_OBSERVADO = "2";
    public static final String TRAMA_ESTADO_RESPUESTA_ERROR_LIBRERIA_SUSALUD = "3";

    //Codigos Errores validacion libreria SUSALUD
    public static final String SERVICIO_SUSALUD_OK = "0000"; //Todo correcto
    public static final String SERVICIO_SUSALUD_ERR_XML = "0010"; //Estructura XML de entrada no corresponde a la definida
    public static final String SERVICIO_SUSALUD_ERR_SISTEMA = "0020"; //Error ocurrido en el flujo de proceso
    public static final String SERVICIO_SUSALUD_ERR_ING_NOM_TRX = "0300"; //No ingreso nombre de Transacción 
    public static final String SERVICIO_SUSALUD_ERR_NOMBRE_NO_EXISTE = "0310"; //No existe el nombre de la transacción
    public static final String SERVICIO_SUSALUD_ERR_NO_INGRESO_TRAMA = "0500"; //No ingreso trama de Transacción

    public static final String VALIDACION_SUSALUD_OK_BD = "0000"; //Todo correcto
    public static final String VALIDACION_SUSALUD_ERROR = "0001"; //error al validar la información input
    public static final String VALIDACION_SUSALUD_ERROR_BD = "0002"; //error de Base de Datos

    //Estados actualizacion Base de Datos
    public static final String ESTADO_TRX_ERROR = "0";
    public static final String ESTADO_TRX_CONFORME = "1";

    public static final String ESTADO_BOOLEAN_TRUE = "1";
    public static final String ESTADO_BOOLEAN_FALSE = "0";

    //Constantes de Base de Datos
    public static final String PKG_SUSALUD = "APP_IAA_INTERFAZ.PQ_IAA_INTSUSALUD";
    //public static final String PKG_SUSALUD = "APP_IAA_INTERFAZ.PQ_IAA_INTMQ";

    //Constantes Oracle Type.
    // ojdbc6.jar no soporta ORACLETYPE que si tiene ojdbc14-10.2.0.2.jar.
    //pero genera conflicto en formato de fecha .0 y sale NullpointerException en Framework Rimac.
    public static final int ORACLETYPE_CURSOR = -10;
    public static final int ORACLETYPE_VARCHAR = 12;

    //Tipos de operacion
    public static final String TIPO_OPERACION_ACTUALIZACION = "12";

    //Codigos IAFAS RIMAC
    public static final String IAFA_RIMAC_EPS = "20001";
    public static final String IAFA_RIMAC_SEGUROS = "40007";

    //Tipos Negocios RIMAC
    public static final String RIMAC_EPS = "EPS";
    public static final String RIMAC_SEGUROS = "SEGUROS";

    public static final String SIMPLE_DATE_FORMAT = "yyyyMMdd";
    public static final String SIMPLE_DATETIME_FORMAT = "yyy-MM-dd_HH-mm-ss";

    //Datos FTP
    public static final String DATA_CHANNEL_PROTECTION_PRIVATE = "P"; // Set data channel protection to private

    public static final String SEPARADOR = "\\|";
    public static final String ERROR_CAMPO_CSV = "resources/errorCampo.csv";
    public static final String ERROR_DESCRIPCION_CSV = "resources/errorDescripcion.csv";
    public static final String TAG271 = "txPeticion";
    public static final String TAG997 = "txRespuesta";
    public static final String CODIGO_ERROR_SUSALUD = "coError";

    public static final String EXTENSION_ARCHIVO_TEXTO = ".txt";

    public static final int CCSID_DEFAULT = 819;
    public static final int ENCODING_NATIVE = 273;

    //codigo de constantes
    public static final String CODIGO_CARGA_INICIAL_ACTIVO = "C_ACTIVE_CARGA_INICIAL_MQ";
    public static final String LIMITE_CARGA_INICIAL_REGISTROS = "C_LIMITE_CARGA_INICIAL_REGISTROS";
    //[INI] RTC-139711 / Pavel Quezada / 24-05-208
    public static final String SERVICIO_SENDER_EJECUCION = "C_SENDER_SERVICIO_EJECUCION";
    public static final String SERVICIO_RECEIVER_EJECUCION = "C_RECEIVER_SERVICIO_EJECUCION";
    //[FIN] RTC-139711 / Pavel Quezada / 24-05-2018
    //[INI] RTC-999999 / Pavel Quezada / 08-06-208
    public static final String IMPRIMIR_TRAMA_X12N = "C_IMPRIMIR_TRAMAX12N";
    //[FIN] RTC-999999 / Pavel Quezada / 08-06-208

    //Tipos de Carga Inicial
    public static final String CARGA_NORMAL = "0"; //INDICADOR DE CARGA INICIAL 0: NORMAL O DIARIO
    public static final String CARGA_ALTAS_EPS = "1"; //ALTAS EPS(40007)
    public static final String CARGA_ALTAS_SEGUROS = "2"; //ALTAS SEGUROS(20001)
    public static final String CARGA_ALTAS_SUSPENSIONES_SEGUROS = "3"; //ALTAS SUSPENSIONES SEGUROS
    public static final String CARGA_ALTAS_ACTUALIZACION_SEGUROS = "4"; //ACTUALIZACION SUSPENSIONES SEGUROS
    public static final String CARGA_ALTAS_EPS_FUTURO = "5"; //ALTAS EPS FUTURO
    public static final String CARGA_ALTAS_SEGUROS_FUTURO = "6"; //ALTAS SEGUROS FUTURO
    public static final String CARGA_ALTAS_SUSPENSIONES_SEGUROS_FUTURO = "7"; //ALTAS SUSPENSIONES SEGUROS FUTURO
    public static final String CARGA_ACTUALIZACION_SUSPENSIONES_SEGUROS_FUTURO = "8"; //ACTUALIZACION SUSPENSIONES SEGUROS FUTURO
    public static final String CARGA_INICIAL_RPTA_SUSALUD = "9"; //RESPUESTA SUSALUD OK
    public static final String CARGA_ERROR = "ERROR";

    //Archivo de Propiedades por cada aplicacion
    public static final String FILE_PROPERTIES_SENDER = "D:\\AppsRimac\\JobSusaludSender\\conf\\app.properties";
    public static final String FILE_PROPERTIES_RECEIVER = "D:\\AppsRimac\\JobSusaludReceiver\\conf\\app.properties";
    public static final String FILE_PROPERTIES_CARGAINICIAL = "D:\\AppsRimac\\JobSusaludSender\\conf\\app.properties";
    public static final String FILE_PROPERTIES_EXTRACCION = "D:\\AppsRimac\\JobSusaludReceiver\\conf\\app.properties";

    public static final String TIPO_PARENTESCO_TITULAR = "1";
    public static final String TIPO_PARENTESCO_CONYUGUE = "2";
    public static final String TIPO_PARENTESCO_HIJO_NO_INCAPACITADO = "5";
    public static final String TIPO_PARENTESCO_HIJO_INCAPACITADO = "6";
}
