package com.dynns.cloudtecnologia.clientes.model.mapper;

import com.dynns.cloudtecnologia.clientes.model.entity.Cliente;
import com.dynns.cloudtecnologia.clientes.rest.dto.ClienteDTOnew;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Cliente clienteDTOnewToCliente(ClienteDTOnew clienteDTOnew) {
        return modelMapper.map(clienteDTOnew, Cliente.class);
    }

    public ClienteDTOnew clienteToClienteDTOnew(Cliente cliente) {
        return modelMapper.map(cliente, ClienteDTOnew.class);
    }
}
