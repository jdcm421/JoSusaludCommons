package com.rimac.susalud.josusaludcommons.service;

import com.rimac.susalud.josusaludcommons.model.In997RegafiUpdate;
import org.springframework.stereotype.Service;

@Service
public interface RegafiUpdate997Service {

    public String beanToX12N(In997RegafiUpdate iru);

    public In997RegafiUpdate x12NToBean(String string);
}
