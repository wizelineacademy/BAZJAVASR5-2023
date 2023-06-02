package com.wizeline.a.model;

import lombok.Data;

@Data
public class TransactionDto {
    private long idSource;
    private long idDestiny;
    private double monto;
}
