package com.dynns.cloudtecnologia.clientes.anottation.impl;

import com.dynns.cloudtecnologia.clientes.anottation.CPFUnico;
import com.dynns.cloudtecnologia.clientes.service.impl.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CPFUnicoImpl implements ConstraintValidator<CPFUnico, String> {

    @Autowired
    private ClienteServiceImpl clienteService;

    @Override
    public boolean isValid(String cpf, ConstraintValidatorContext context) {
        return clienteService.findByCpfOptional(cpf).isEmpty();
    }
}
