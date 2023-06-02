package com.wizeline.b.springretry.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wizeline.b.springretry.service.PokemonService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/pokemon")
@AllArgsConstructor
public class PokemonController {

    private PokemonService pokemonService;

    @GetMapping("/{name}")
    public String getPokemonByName(@PathVariable String name) {
        return pokemonService.getPokemonByName(name);
    }
}
