package com.rimac.susalud.josusaludcommons.model;

import java.util.ArrayList;

public class In997RegafiUpdate {

    private String excProceso;
    private String feTransaccion;
    private String hoTransaccion;
    private String idCorrelativo;
    private String idReceptor;
    private String idRemitente;
    private String idTransaccion;
    private String noTransaccion;
    private String nuControl;
    private String nuControlST;
    private In997RegafiUpdateException in997RegafiUpdateException;
    private ArrayList<In997RegafiUpdateException> detallesException;
    private boolean flag;

    public String getExcProceso() {
        return excProceso;
    }

    public void setExcProceso(String excProceso) {
        this.excProceso = excProceso;
    }

    public String getFeTransaccion() {
        return feTransaccion;
    }

    public void setFeTransaccion(String feTransaccion) {
        this.feTransaccion = feTransaccion;
    }

    public String getHoTransaccion() {
        return hoTransaccion;
    }

    public void setHoTransaccion(String hoTransaccion) {
        this.hoTransaccion = hoTransaccion;
    }

    public String getIdCorrelativo() {
        return idCorrelativo;
    }

    public void setIdCorrelativo(String idCorrelativo) {
        this.idCorrelativo = idCorrelativo;
    }

    public String getIdReceptor() {
        return idReceptor;
    }

    public void setIdReceptor(String idReceptor) {
        this.idReceptor = idReceptor;
    }

    public String getIdRemitente() {
        return idRemitente;
    }

    public void setIdRemitente(String idRemitente) {
        this.idRemitente = idRemitente;
    }

    public String getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(String idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public String getNoTransaccion() {
        return noTransaccion;
    }

    public void setNoTransaccion(String noTransaccion) {
        this.noTransaccion = noTransaccion;
    }

    public String getNuControl() {
        return nuControl;
    }

    public void setNuControl(String nuControl) {
        this.nuControl = nuControl;
    }

    public String getNuControlST() {
        return nuControlST;
    }

    public void setNuControlST(String nuControlST) {
        this.nuControlST = nuControlST;
    }

    public In997RegafiUpdateException getIn997RegafiUpdateException() {
        return in997RegafiUpdateException;
    }

    public void setIn997RegafiUpdateException(In997RegafiUpdateException in997RegafiUpdateException) {
        this.in997RegafiUpdateException = in997RegafiUpdateException;
    }

    public ArrayList<In997RegafiUpdateException> getDetallesException() {
        return detallesException;
    }

    public void setDetallesException(ArrayList<In997RegafiUpdateException> detallesException) {
        this.detallesException = detallesException;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
