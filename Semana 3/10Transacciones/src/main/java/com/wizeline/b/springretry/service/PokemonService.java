package com.wizeline.b.springretry.service;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import com.wizeline.b.springretry.client.PokemonServiceClient;
import com.wizeline.b.springretry.exception.PokemonServiceException;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Log4j2
public class PokemonService {

    private PokemonServiceClient pokemonServiceClient;

    @Retryable(value = {PokemonServiceException.class}, maxAttempts = 4, backoff = @Backoff(delay = 1000))
    public String getPokemonByName(String name) {
        log.info("Entrando a getPokemonByName");
        return pokemonServiceClient.getPokemonByName(name);
    }
}
