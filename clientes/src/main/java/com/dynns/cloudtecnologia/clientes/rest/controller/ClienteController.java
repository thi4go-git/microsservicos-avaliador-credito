package com.dynns.cloudtecnologia.clientes.rest.controller;

import com.dynns.cloudtecnologia.clientes.model.entity.Cliente;
import com.dynns.cloudtecnologia.clientes.model.mapper.ClienteMapper;
import com.dynns.cloudtecnologia.clientes.rest.dto.ClienteDTOnew;
import com.dynns.cloudtecnologia.clientes.service.impl.ClienteServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.net.URI;

@RestController
@RequestMapping("api/clientes")
public class ClienteController {

    @Autowired
    private ClienteServiceImpl clienteService;

    @Autowired
    private ClienteMapper clienteMapper;


    @GetMapping("/status")
    ResponseEntity<String> getStatusApi() {
        String staus = "Microsserviço de Clientes rodando!";
        return ResponseEntity.ok(staus);
    }

    @PostMapping
    @Operation(summary = "Criar Cliente", description = "Este endpoint Cria um Cliente.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cliente criado!"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    ResponseEntity<ClienteDTOnew> save(
            @RequestBody @Valid ClienteDTOnew clienteDTOnew
    ) {
        Cliente cliente = clienteService.save(clienteDTOnew);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(cliente.getId())
                .toUri();
        return ResponseEntity.created(location).body(clienteMapper.clienteToClienteDTOnew(cliente));
    }


    @GetMapping("/{cpf}")
    @Operation(summary = "Buscar cliente pelo CPF", description = "Este endpoint busca cliente pelo CPF")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente Localizado!"),
            @ApiResponse(responseCode = "404", description = "Cliente não Localizado"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    ResponseEntity<ClienteDTOnew> getByCpf(
            @PathVariable("cpf") @NotBlank(message = "O cpf é obrigatório!") final String cpf
    ) {
        Cliente cliente = clienteService.findByCpfOrThrow(cpf);
        return ResponseEntity.ok().body(clienteMapper.clienteToClienteDTOnew(cliente));
    }
}
