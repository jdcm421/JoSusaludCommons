package com.rimac.susalud.josusaludcommons.controller;

import com.rimac.susalud.josusaludcommons.exception.ExceptionResponse;
import com.rimac.susalud.josusaludcommons.response.Response;
import com.rimac.susalud.josusaludcommons.service.AfiliadoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/commons")
@Api(value = "commons", produces = "application/json", tags = {"Controlador Commons"})
public class CommnsController {
    
    @Autowired
    AfiliadoService service;
    
    @ApiOperation(value = "Se obtiene el afiliado de envio", tags = {"Controlador Commons"})
    @GetMapping(value = "/obtener/afiliado-envio", produces = "application/json")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK", response = Response.class),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Error en el Servidor", response = ExceptionResponse.class)
    })
    public ResponseEntity<Response> obternerAfliadosEnvio(@RequestParam String filePropertiesName, @RequestParam String estadoAfiliado){
        return null;
    }
    
    @ApiOperation(value = "Obtiene el afiliado para carga inicial", tags = {"Controlador Commons"})
    @GetMapping(value = "/obtener/afiliado-cargainicial", produces = "application/json")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK", response = Response.class),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Error en el Servidor", response = ExceptionResponse.class)
    })
    public ResponseEntity<Response> obternerAfiliadoCargaInicial(@RequestParam String filePropertiesName, @RequestParam String estadoAfiliado){
        return null;
    }
    
    @ApiOperation(value = "Obtener afiliados de SuSalud", tags = {"Controlador Commons"})
    @GetMapping(value = "/obtener/afiliado-susalud", produces = "application/json")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK", response = Response.class),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Error en el Servidor", response = ExceptionResponse.class)
    })
    public ResponseEntity<Response> obternerAfliadoSuSalud(@RequestParam String filePropertiesName, @RequestParam String estadoAfiliado){
        return null;
    }
    
    @ApiOperation(value = "Obtener el id de mensaje de envio", tags = {"Controlador Commons"})
    @GetMapping(value = "/obtener/message-envio", produces = "application/json")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK", response = Response.class),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Error en el Servidor", response = ExceptionResponse.class)
    })
    public ResponseEntity<Response> obternerIdMessageEnvio(@RequestParam String filePropertiesName, @RequestParam String estadoAfiliado){
        return null;
    }
    
    @ApiOperation(value = "Insertar respuesta susalud", tags = {"Controlador Commons"})
    @PostMapping(value = "/insertar/susalud", consumes = "application/json", produces = "application/json")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK", response = Response.class),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Error en el Servidor", response = ExceptionResponse.class)
    })
    public ResponseEntity<Response> insertarSuSaludRespuesta(@RequestParam String filePropertiesName, @RequestParam String estadoAfiliado){
        return null;
    }
    
    @ApiOperation(value = "Actalizar id del Mensaje", tags = {"Controlador Commons"})
    @PutMapping(value = "/actualizar/id", consumes = "application/json", produces = "application/json")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK", response = Response.class),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Error en el Servidor", response = ExceptionResponse.class)
    })
    public ResponseEntity<Response> actualizarIdMessage(@RequestParam String filePropertiesName, @RequestParam String estadoAfiliado){
        return null;
    }
    
    @ApiOperation(value = "Actualizar la trama del Afiliado", tags = {"Controlador Commons"})
    @PutMapping(value = "/actualizar/afiliado", consumes = "application/json", produces = "application/json")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK", response = Response.class),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Error en el Servidor", response = ExceptionResponse.class)
    })
    public ResponseEntity<Response> actualizarTramaAfiliado(@RequestParam String filePropertiesName, @RequestParam String estadoAfiliado){
        return null;
    }
    
    
}
