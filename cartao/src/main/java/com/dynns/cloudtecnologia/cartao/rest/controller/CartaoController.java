package com.dynns.cloudtecnologia.cartao.rest.controller;

import com.dynns.cloudtecnologia.cartao.model.entity.Cartao;
import com.dynns.cloudtecnologia.cartao.model.mapper.CartaoMapper;
import com.dynns.cloudtecnologia.cartao.rest.dto.CartaoDTOnew;
import com.dynns.cloudtecnologia.cartao.service.impl.CartaoServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.net.URI;

@Slf4j
@RestController
@RequestMapping("/cartoes")
public class CartaoController {

    @Autowired
    private CartaoServiceImpl cartaoService;

    @Autowired
    private CartaoMapper cartaoMapper;

    private static final String SERVICO_OFF = "Internal Server Error";


    @GetMapping("/status")
    @Operation(summary = "Status serviço", description = "Este endpoint Consulta status do serviço")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Serviço rodando"),
            @ApiResponse(responseCode = "500", description = SERVICO_OFF)
    })
    ResponseEntity<String> getStatusApi() {
        String staus = "Microsserviço de Cartões rodando!";
        log.info(staus);
        return ResponseEntity.ok(staus);
    }

    @PostMapping
    @Operation(summary = "Criar Cartão", description = "Este endpoint Cria um Cartão.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cliente criado!"),
            @ApiResponse(responseCode = "500", description = SERVICO_OFF)
    })
    ResponseEntity<CartaoDTOnew> save(
            @RequestBody @Valid CartaoDTOnew cartaoDTOnew
    ) {
        Cartao novo = cartaoService.save(cartaoDTOnew);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(novo.getId())
                .toUri();
        return ResponseEntity.created(location).body(cartaoMapper.cartaoToCartaoDTOnew(novo));
    }


    @GetMapping("/{id}")
    ResponseEntity<CartaoDTOnew> findById(
            @PathVariable("id") @NotBlank(message = "O id é obrigatório!") final Long id
    ) {
        Cartao achado = cartaoService.findByIdOrThrow(id);
        return ResponseEntity.ok(cartaoMapper.cartaoToCartaoDTOnew(achado));
    }
}
