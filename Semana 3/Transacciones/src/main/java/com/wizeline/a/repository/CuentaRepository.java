package com.wizeline.a.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wizeline.a.entity.Cuenta;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
    // Métodos personalizados, si es necesario
}