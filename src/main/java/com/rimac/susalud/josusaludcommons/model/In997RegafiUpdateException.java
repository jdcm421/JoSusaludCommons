package com.rimac.susalud.josusaludcommons.model;

public class In997RegafiUpdateException {

    private String coCampoErr;
    private String excBD;
    private String pkAfiliado;
    private String pkAfiliadopkAfiliacion;
    private String inCoErrorEncontrado;
    private boolean flagExcepcion;

    public String getCoCampoErr() {
        return coCampoErr;
    }

    public void setCoCampoErr(String coCampoErr) {
        this.coCampoErr = coCampoErr;
    }

    public String getExcBD() {
        return excBD;
    }

    public void setExcBD(String excBD) {
        this.excBD = excBD;
    }

    public String getPkAfiliado() {
        return pkAfiliado;
    }

    public void setPkAfiliado(String pkAfiliado) {
        this.pkAfiliado = pkAfiliado;
    }

    public String getPkAfiliadopkAfiliacion() {
        return pkAfiliadopkAfiliacion;
    }

    public void setPkAfiliadopkAfiliacion(String pkAfiliadopkAfiliacion) {
        this.pkAfiliadopkAfiliacion = pkAfiliadopkAfiliacion;
    }

    public String getInCoErrorEncontrado() {
        return inCoErrorEncontrado;
    }

    public void setInCoErrorEncontrado(String inCoErrorEncontrado) {
        this.inCoErrorEncontrado = inCoErrorEncontrado;
    }

    public boolean isFlagExcepcion() {
        return flagExcepcion;
    }

    public void setFlagExcepcion(boolean flagExcepcion) {
        this.flagExcepcion = flagExcepcion;
    }

}
