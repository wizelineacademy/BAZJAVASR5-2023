package com.wizeline.a.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Reflection {
    public static void main(String[] args)
            throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException,
            IllegalAccessException, NoSuchFieldException {
        Persona julia = new Persona();
        Class<?> informacionPersona = julia.getClass();

        // Class<?> informacionPersona = Persona.class;

        Class<?> persona = Class.forName("com.wizeline.a.reflection.Persona");

        log.info(persona.getSimpleName());
        log.info(persona.getName());
        log.info(persona.getCanonicalName());

         log.info(informacionPersona.getModifiers());

        Constructor<?>[] constructors = persona.getConstructors();
        log.info (constructors.length);

        Arrays.stream(constructors).forEach(constructor -> log.info(constructor.getParameterCount()));

        Constructor<?> constructor = persona.getConstructor(String.class, int.class);
        Persona juan = (Persona) constructor.newInstance("Juan", 2);
        log.info(juan.getNombre());

        Arrays.stream(persona.getFields()).forEach(log::info);
        // public java.lang.String com.wizeline.Persona.nombre

        Arrays.stream(persona.getDeclaredFields()).forEach(log::info);
        // public java.lang.String com.wizeline.Persona.nombre
        // private int com.wizeline.Persona.edad

        Field nombre = juan.getClass().getField("nombre");
        nombre.set (juan, "Antonio");
        log.info(juan.getNombre());

        Field edad = juan.getClass().getDeclaredField("edad");
        edad.setAccessible(true);
        edad.setInt(juan, 5);

        Method getNombre = juan.getClass().getMethod("getNombre");
        log.info((String) getNombre.invoke(juan));

        Method getEdad = juan.getClass().getDeclaredMethod("getEdad");
        getEdad.setAccessible(true);
        log.info((int) getEdad.invoke(juan));
    }

}
