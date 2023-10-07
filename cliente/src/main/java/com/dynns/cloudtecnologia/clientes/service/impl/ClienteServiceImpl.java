package com.dynns.cloudtecnologia.clientes.service.impl;

import com.dynns.cloudtecnologia.clientes.model.entity.Cliente;
import com.dynns.cloudtecnologia.clientes.model.mapper.ClienteMapper;
import com.dynns.cloudtecnologia.clientes.model.repository.ClienteRepository;
import com.dynns.cloudtecnologia.clientes.rest.dto.ClienteDTOnew;
import com.dynns.cloudtecnologia.clientes.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    @Override
    public Optional<Cliente> findByCpfOptional(String cpf) {
        return clienteRepository.findByCpf(cpf);
    }

    @Override
    @Transactional
    public Cliente save(ClienteDTOnew clienteDTOnew) {
        Cliente cliente = clienteMapper.clienteDTOnewToCliente(clienteDTOnew);
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente findByCpfOrThrow(String cpf) {
        return clienteRepository.
                findByCpf(cpf)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não localizado com o CPF: " + cpf));
    }
}
