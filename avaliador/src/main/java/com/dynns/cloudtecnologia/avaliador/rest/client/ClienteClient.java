package com.dynns.cloudtecnologia.avaliador.rest.client;

import com.dynns.cloudtecnologia.rest.dto.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "ms-cliente", path = "/api/clientes")
public interface ClienteClient {

    @GetMapping(value = "/{cpf}")
    ResponseEntity<ClienteDTOnew> getClienteByCpf(@PathVariable("cpf") String cpf);

}
