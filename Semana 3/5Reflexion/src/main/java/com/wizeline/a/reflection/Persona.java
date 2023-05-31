package com.wizeline.a.reflection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Persona {
    public String nombre = "Julia";
    private int edad = 10;
    private boolean esMasculino;
}
