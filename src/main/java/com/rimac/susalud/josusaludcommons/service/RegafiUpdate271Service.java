package com.rimac.susalud.josusaludcommons.service;

import com.rimac.susalud.josusaludcommons.model.In271RegafiUpdate;

public interface RegafiUpdate271Service {

    public String beanToX12N(In271RegafiUpdate iru);

    public In271RegafiUpdate x12NToBean(String string);
}
