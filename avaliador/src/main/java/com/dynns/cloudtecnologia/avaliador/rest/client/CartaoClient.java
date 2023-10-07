package com.dynns.cloudtecnologia.avaliador.rest.client;

import com.dynns.cloudtecnologia.avaliador.rest.dto.CartaoDTOnew;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "ms-cartao", path = "/api/cartoes")
public interface CartaoClient {

    @GetMapping(value = "/{id}")
    ResponseEntity<CartaoDTOnew> getCartaoById(@PathVariable("id") Long id);

}
