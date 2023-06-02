package com.wizeline.a.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wizeline.a.entity.Cuenta;
import com.wizeline.a.repository.CuentaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CuentaService {

    private CuentaRepository cuentaRepository;

    @Transactional
    public void transferirDinero(long origen, long destino, double monto) {
        Optional<Cuenta> cuentaOrigen = cuentaRepository.findById(origen);
        Optional<Cuenta> cuentaDestino = cuentaRepository.findById(destino);
        // Lógica de transferencia de dinero
        cuentaOrigen.get().debitar(monto);
        cuentaDestino.get().abonar(monto);
        cuentaRepository.save(cuentaOrigen.get());
        cuentaRepository.save(cuentaDestino.get());
    }
}
