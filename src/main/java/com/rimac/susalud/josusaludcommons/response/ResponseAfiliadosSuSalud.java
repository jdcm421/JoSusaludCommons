package com.rimac.susalud.josusaludcommons.response;

import java.util.List;

import com.rimac.susalud.josusaludcommons.model.AfiliadoRespuesta;

public class ResponseAfiliadosSuSalud extends Response {

    List<AfiliadoRespuesta> obtenerAfiliadosSuSalud;

    public List<AfiliadoRespuesta> getObtenerAfiliadosSuSalud() {
        return obtenerAfiliadosSuSalud;
    }

    public void setObtenerAfiliadosSuSalud(List<AfiliadoRespuesta> obtenerAfiliadosSuSalud) {
        this.obtenerAfiliadosSuSalud = obtenerAfiliadosSuSalud;
    }
}
