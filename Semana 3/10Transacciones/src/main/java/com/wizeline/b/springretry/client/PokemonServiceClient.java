package com.wizeline.b.springretry.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "pokemonService", url = "https://pokeapi.co/api/v2/pokemon/")
public interface PokemonServiceClient {

    @RequestMapping(method = RequestMethod.POST, value = "{name}", produces = "application/json")
    String getPokemonByName(@PathVariable String name);
}