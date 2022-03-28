package com.rimac.susalud.josusaludcommons.request;

public class MessageRequest {

    private String filePropertiesName;
    private String idTrama;
    private byte[] idmessage;

    public String getFilePropertiesName() {
        return filePropertiesName;
    }

    public void setFilePropertiesName(String filePropertiesName) {
        this.filePropertiesName = filePropertiesName;
    }

    public String getIdTrama() {
        return idTrama;
    }

    public void setIdTrama(String idTrama) {
        this.idTrama = idTrama;
    }

    public byte[] getIdmessage() {
        return idmessage;
    }

    public void setIdmessage(byte[] idmessage) {
        this.idmessage = idmessage;
    }

}
