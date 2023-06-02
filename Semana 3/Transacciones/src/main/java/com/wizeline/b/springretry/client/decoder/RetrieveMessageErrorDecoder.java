package com.wizeline.b.springretry.client.decoder;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.stereotype.Component;

import com.wizeline.b.springretry.exception.PokemonServiceException;

import feign.Response;
import feign.codec.ErrorDecoder;

@Component
public class RetrieveMessageErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        String message;
        try (InputStream bodyIs = response.body().asInputStream()) {
            message = new String (bodyIs.readAllBytes());
        } catch (IOException e) {
            return new Exception(e.getMessage());
        }

        return new PokemonServiceException("Error al obtener el Pokemon de PokeAPI: " + message);
    }
}