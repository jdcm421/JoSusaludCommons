package com.rimac.susalud.josusaludcommons.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FTPSDownload {
	
	static Logger logger = LoggerFactory.getLogger(FTPSDownload.class);
	
public TreeMap<String, String> descargarArchivoFTPS(String filePropertiesName, String tipoRimac) throws IOException, Exception{
		
		TreeMap<String, String> mapArchivosDescargados = new TreeMap<String, String>();
		FTPSClient ftpsClient = null;
		
		try{
			Properties prop = AfiliacionUtil.loadFileProperties(filePropertiesName);
			
	        String server = prop.getProperty("FTP.SUSALUD.SERVER").trim();
	        int port = Integer.parseInt(prop.getProperty("FTP.SUSALUD.PORT").trim());
			
	        String user = tipoRimac.equals(Constants.RIMAC_EPS)?prop.getProperty("FTP.SUSALUD.EPS.USERID"):prop.getProperty("FTP.SUSALUD.SEG.USERID");
	        String pass = tipoRimac.equals(Constants.RIMAC_EPS)?prop.getProperty("FTP.SUSALUD.EPS.PASSWORD"):prop.getProperty("FTP.SUSALUD.SEG.PASSWORD");
			
			String sourcePath = tipoRimac.equals(Constants.RIMAC_EPS)?prop.getProperty("FTP.SUSALUD.EPS.SOURCEDIRECTORY"):prop.getProperty("FTP.SUSALUD.SEG.SOURCEDIRECTORY");
			String targetLocalPath = prop.getProperty("FTP.LOCAL.DIRECTORY").trim();
			
			ftpsClient = new FTPSClient();
			ftpsClient.connect(server, port);
			int reply = ftpsClient.getReplyCode();
			if(FTPReply.isPositiveCompletion(reply)) {
				if(ftpsClient.login(user, pass)){
					ftpsClient.execPBSZ(0);
					ftpsClient.execPROT(Constants.DATA_CHANNEL_PROTECTION_PRIVATE);
					ftpsClient.enterLocalPassiveMode();
					ftpsClient.setFileType(FTP.ASCII_FILE_TYPE);
					FTPFile[] listFiles = ftpsClient.listFiles(sourcePath);
					if(listFiles.length>0){
						for(FTPFile file : listFiles){
							String fechaActual = AfiliacionUtil.obtenerFecha(Constants.SIMPLE_DATE_FORMAT, new Date());
							String fechaArchivo = AfiliacionUtil.obtenerFecha(Constants.SIMPLE_DATE_FORMAT, file.getTimestamp().getTime());
							if(fechaArchivo.equals(fechaActual)){
								if(!archivoFueDescargado(targetLocalPath, file.getName())){
									logger.info("Obteniendo archivo FTP: " + file.getName() + " - " + AfiliacionUtil.readableFileSize(file.getSize()));
									OutputStream outputStream = new FileOutputStream(targetLocalPath + file.getName());
									boolean rpta = ftpsClient.retrieveFile(sourcePath + file.getName(), outputStream);
									logger.info("Archivo FTP descargado: " + rpta);
									mapArchivosDescargados.put(file.getName(), file.getName());
									outputStream.close();
								}
							}
						}
					}
				}
				else
					logger.info("FTP login failed: " + ftpsClient.getReplyString());
			}
			else
				logger.info("FTP connect to host failed: " + ftpsClient.getReplyString());
		}
		catch(IOException ex){
			throw ex;
		}
		catch(Exception ex){
			throw ex;
		}
		finally{
			try{
				if(ftpsClient.isConnected()){
					ftpsClient.logout();
					ftpsClient.disconnect();
				}
			}
			catch(IOException ex){
				throw ex;
			}
		}
		
		return mapArchivosDescargados;
	}
	
	//Valida si archivo fue descargo anteriormente
	private boolean archivoFueDescargado(String nombreCarpetaLocal, String nombreArchivo){
		boolean bFueDescargado = false;
		File myLocalFolder = new File(nombreCarpetaLocal);
		File[] listLocalFiles = myLocalFolder.listFiles();
		
		for(File file : listLocalFiles){
			if(file.getName().equals(nombreArchivo)){
				bFueDescargado = true;
				break;
			}
		}
		
		return bFueDescargado;
	}
}
