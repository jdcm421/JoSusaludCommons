package com.rimac.susalud.josusaludcommons.service.impl;

import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rimac.susalud.josusaludcommons.model.In997RegafiUpdate;
import com.rimac.susalud.josusaludcommons.repository.AfiliadoRepository;
import com.rimac.susalud.josusaludcommons.response.Response;
import com.rimac.susalud.josusaludcommons.response.ResponseAfiliadosSuSalud;
import com.rimac.susalud.josusaludcommons.response.ResponseObtenerAfiliados;
import com.rimac.susalud.josusaludcommons.service.AfiliadoService;

@Service
public class AfiliadoServiceImpl implements AfiliadoService {

    private static final Logger LOG = LoggerFactory.getLogger(AfiliadoServiceImpl.class);

    @Autowired
    AfiliadoRepository afiliadoRepository;

	@Override
	public ResponseAfiliadosSuSalud obtenerAfiliadosEnvio(String filePropertiesName, String estadoAfiliado) {
		try {
			
		}catch (Exception ex) {
			// TODO: handle exception
		}
	}

	@Override
	public ResponseAfiliadosSuSalud obtenerAfiliadosCargaInicial(String filePropertiesName, String estadoAfiliado,
			String indicadorCargaInicial) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response actualizarTramaAfiliado(String filePropertiesName, String idTrama, String estadoAfiliado){
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseObtenerAfiliados obtenerAfiliadosSuSalud(String filePropertiesName, String estadoTrama){
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response insertarSuSaludRespuesta(String filePropertiesName, String tramaestado, String indcargainicial,
			In997RegafiUpdate afiliadoRpta, byte[] msgId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response actualizarIdMessage(String filePropertiesName, String idTrama, byte[] idmessage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response obtenerIdmessageEnvio(String filePropertiesName, String estadoAfiliado) {
		// TODO Auto-generated method stub
		return null;
	}

	
    

}
