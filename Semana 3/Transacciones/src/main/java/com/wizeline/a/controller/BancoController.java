package com.wizeline.a.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wizeline.a.model.TransactionDto;
import com.wizeline.a.service.CuentaService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/cuentas")
@AllArgsConstructor
public class BancoController {
    private CuentaService cuentaService;

    @PostMapping("/movimiento")
    private void doTransation(@RequestBody TransactionDto transactionDto) {
        cuentaService.transferirDinero(transactionDto.getIdSource(), transactionDto.getIdDestiny(),
                transactionDto.getMonto());
    }
}