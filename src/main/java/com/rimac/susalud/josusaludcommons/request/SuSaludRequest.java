package com.rimac.susalud.josusaludcommons.request;

import com.rimac.susalud.josusaludcommons.model.In997RegafiUpdate;

public class SuSaludRequest extends AfiliadoRequest {

	private String tramaestado;
    private String indcargainicial;
    private In997RegafiUpdate afiliadoRpta;
    private byte[] msgId;

    
    public String getTramaestado() {
		return tramaestado;
	}

	public void setTramaestado(String tramaestado) {
		this.tramaestado = tramaestado;
	}

	public String getIndcargainicial() {
        return indcargainicial;
    }

    public void setIndcargainicial(String indcargainicial) {
        this.indcargainicial = indcargainicial;
    }

    public In997RegafiUpdate getAfiliadoRpta() {
        return afiliadoRpta;
    }

    public void setAfiliadoRpta(In997RegafiUpdate afiliadoRpta) {
        this.afiliadoRpta = afiliadoRpta;
    }

    public byte[] getMsgId() {
        return msgId;
    }

    public void setMsgId(byte[] msgId) {
        this.msgId = msgId;
    }

}
