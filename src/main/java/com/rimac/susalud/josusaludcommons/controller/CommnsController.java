package com.rimac.susalud.josusaludcommons.controller;

import com.rimac.susalud.josusaludcommons.exception.ExceptionResponse;
import com.rimac.susalud.josusaludcommons.request.MessageRequest;
import com.rimac.susalud.josusaludcommons.request.SuSaludRequest;
import com.rimac.susalud.josusaludcommons.response.ResponseDTO;
import com.rimac.susalud.josusaludcommons.response.ResponseAfiliadosSuSalud;
import com.rimac.susalud.josusaludcommons.response.ResponseDatosMQ;
import com.rimac.susalud.josusaludcommons.response.ResponseObtenerAfiliados;
import com.rimac.susalud.josusaludcommons.service.AfiliadoService;
import com.rimac.susalud.josusaludcommons.service.ComunService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/commons")
@Api(value = "commons", produces = "application/json", tags = {"Controlador Commons"})
public class CommnsController {
    
    @Autowired
    AfiliadoService service;
    
    @Autowired
    ComunService comunService;
    
    @ApiOperation(value = "Se obtiene el afiliado de envio", tags = {"Controlador Commons"})
    @GetMapping(value = "/obtener/afiliado-envio", produces = "application/json")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK", response = ResponseObtenerAfiliados.class),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Error en el Servidor", response = ExceptionResponse.class)
    })
    public ResponseEntity<ResponseObtenerAfiliados> obternerAfliadosEnvio(@RequestParam String estadoAfiliado) {
        return ResponseEntity.ok().body(service.obtenerAfiliadosEnvio(estadoAfiliado));
    }
    
    @ApiOperation(value = "Obtiene el afiliado para carga inicial", tags = {"Controlador Commons"})
    @GetMapping(value = "/obtener/afiliado-cargainicial", produces = "application/json")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK", response = ResponseObtenerAfiliados.class),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Error en el Servidor", response = ExceptionResponse.class)
    })
    public ResponseEntity<ResponseObtenerAfiliados> obternerAfiliadoCargaInicial(@RequestParam String estadoAfiliado, @RequestParam String indicadorCargaInicial) {
        return ResponseEntity.ok().body(service.obtenerAfiliadosCargaInicial(estadoAfiliado, indicadorCargaInicial));
    }
    
    @ApiOperation(value = "Obtener afiliados de SuSalud", tags = {"Controlador Commons"})
    @GetMapping(value = "/obtener/afiliado-susalud", produces = "application/json")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK", response = ResponseAfiliadosSuSalud.class),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Error en el Servidor", response = ExceptionResponse.class)
    })
    public ResponseEntity<ResponseAfiliadosSuSalud> obternerAfliadoSuSalud(@RequestParam String estadoTrama) {
        return ResponseEntity.ok().body(service.obtenerAfiliadosSuSalud(estadoTrama));
    }
    
    @ApiOperation(value = "Obtener el id de mensaje de envio", tags = {"Controlador Commons"})
    @GetMapping(value = "/obtener/message-envio", produces = "application/json")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK", response = ResponseDTO.class),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Error en el Servidor", response = ExceptionResponse.class)
    })
    public ResponseEntity<ResponseDTO> obternerIdMessageEnvio(@RequestParam String estadoAfiliado) {
        return ResponseEntity.ok().body(service.obtenerIdmessageEnvio(estadoAfiliado));
    }
    
    @ApiOperation(value = "Insertar respuesta susalud", tags = {"Controlador Commons"})
    @PostMapping(value = "/insertar/susalud", consumes = "application/json", produces = "application/json")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK", response = ResponseDTO.class),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Error en el Servidor", response = ExceptionResponse.class)
    })
    public ResponseEntity<ResponseDTO> insertarSuSaludRespuesta(@RequestBody SuSaludRequest request) {
        return ResponseEntity.ok().body(service.insertarSuSaludRespuesta(request.getTramaestado(), request.getIndcargainicial(), request.getAfiliadoRpta(), request.getMsgId()));
    }
    
    @ApiOperation(value = "Actalizar id del Mensaje", tags = {"Controlador Commons"})
    @PutMapping(value = "/actualizar/id", consumes = "application/json", produces = "application/json")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK", response = ResponseDTO.class),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Error en el Servidor", response = ExceptionResponse.class)
    })
    public ResponseEntity<ResponseDTO> actualizarIdMessage(@RequestBody MessageRequest request) {
        return ResponseEntity.ok().body(service.actualizarIdMessage(request.getIdTrama(), request.getIdmessage()));
    }
    
    @ApiOperation(value = "Actualizar la trama del Afiliado", tags = {"Controlador Commons"})
    @PutMapping(value = "/actualizar/afiliado", consumes = "application/json", produces = "application/json")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK", response = ResponseDTO.class),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Error en el Servidor", response = ExceptionResponse.class)
    })
    public ResponseEntity<ResponseDTO> actualizarTramaAfiliado(@RequestParam String idTrama, @RequestParam String estadoAfiliado) {
        return ResponseEntity.ok().body(service.actualizarTramaAfiliado(idTrama, estadoAfiliado));
    }
    
    @ApiOperation(value = "Se obtiene los datos de MQ", tags = {"Controlador Commons"})
    @GetMapping(value = "/obtener/datosMQ", produces = "application/json")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK", response = ResponseDatosMQ.class),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Error en el Servidor", response = ExceptionResponse.class)
    })
    public ResponseEntity<ResponseDatosMQ> obtenerDatosMQ() {
        return ResponseEntity.ok().body(comunService.obtenerDatosMQ());
    }
    
    @ApiOperation(value = "Se obtienes los valores del parametro enviado", tags = {"Controlador Commons"})
    @GetMapping(value = "/obtener/valor/{parametro}", produces = "application/json")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK", response = ResponseDTO.class),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Error en el Servidor", response = ExceptionResponse.class)
    })
    public ResponseEntity<ResponseDTO> obtenerValorParametro(@PathVariable String parametro) {
        return ResponseEntity.ok().body(comunService.obtenerValorParametro(parametro));
    }
}
