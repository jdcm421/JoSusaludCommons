package com.rimac.susalud.josusaludcommons.response;

import com.rimac.susalud.josusaludcommons.model.AfiliadoEnvio;
import java.util.List;

import com.rimac.susalud.josusaludcommons.model.AfiliadoRespuesta;

public class ResponseAfiliadosSuSalud extends Response {

    List<AfiliadoEnvio> obtenerAfiliadosSuSalud;

    public List<AfiliadoEnvio> getObtenerAfiliadosSuSalud() {
        return obtenerAfiliadosSuSalud;
    }

    public void setObtenerAfiliadosSuSalud(List<AfiliadoEnvio> obtenerAfiliadosSuSalud) {
        this.obtenerAfiliadosSuSalud = obtenerAfiliadosSuSalud;
    }
}
