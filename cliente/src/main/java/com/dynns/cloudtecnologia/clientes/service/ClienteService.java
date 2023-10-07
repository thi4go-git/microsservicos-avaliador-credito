package com.dynns.cloudtecnologia.clientes.service;

import com.dynns.cloudtecnologia.clientes.model.entity.Cliente;
import com.dynns.cloudtecnologia.clientes.rest.dto.ClienteDTOnew;

import java.util.Optional;

public interface ClienteService {
    Optional<Cliente> findByCpfOptional(String cpf);

    Cliente save(ClienteDTOnew clienteDTOnew);

    Cliente findByCpfOrThrow(String cpf);
}
