package com.dynns.cloudtecnologia.clientes.rest.dto;

import com.dynns.cloudtecnologia.clientes.anottation.CPFUnico;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTOnew {

    @NotBlank(message = "O cpf deverá ser informado.")
    @Size(min = 11, max = 11, message = "O cpf deverá conter 11 caracteres.")
    @Pattern(regexp = "\\d{11}", message = "O cpf deverá conter apenas números.")
    @CPFUnico
    private String cpf;

    @NotBlank(message = "O nome deverá ser informado.")
    private String nome;

    @NotNull(message = "A idade deverá ser informada    .")
    private Integer idade;
}
