package com.dynns.cloudtecnologia.avaliador.rest.controller;


import com.dynns.cloudtecnologia.avaliador.rest.dto.AvaliacaoDTO;
import com.dynns.cloudtecnologia.avaliador.service.impl.AvaliadorServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/avaliador")
public class AvaliadorController {


    @Autowired
    private AvaliadorServiceImpl avaliadorService;

    private static final String ERRO_500_MSG = "Internal Error";

    @GetMapping("/status")
    @Operation(summary = "Status", description = "Este endpoint verifica o Status")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Serviço Ativo !"),
            @ApiResponse(responseCode = "500", description = ERRO_500_MSG)
    })
    ResponseEntity<String> getStatusApi() {
        String staus = "Microsserviço Avaliador Rodando!";
        log.info(staus);
        return ResponseEntity.ok(staus);
    }


    @PostMapping("/avaliar")
    @Operation(summary = "Avaliar Pedido", description = "Este endpoint REaliza Avaliação")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Avaliação realizada!"),
            @ApiResponse(responseCode = "500", description = ERRO_500_MSG)
    })
    ResponseEntity<AvaliacaoDTO> retornarAvaliacao(
            @RequestParam(value = "idCartao", defaultValue = "0") Long idCartao,
            @RequestParam(value = "cpfCliente", defaultValue = "cpf") String cpfCliente
    ) {
        AvaliacaoDTO avaliacaoDTO = avaliadorService.avaliar(idCartao, cpfCliente);
        return ResponseEntity.ok(avaliacaoDTO);
    }


}
