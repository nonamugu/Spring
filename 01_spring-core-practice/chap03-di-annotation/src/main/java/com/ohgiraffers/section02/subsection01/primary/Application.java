package com.ohgiraffers.section02.subsection01.primary;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.ohgiraffers.section02");
        PokemonService pokemonService = context.getBean("pokemonServicePrimary", PokemonService.class);

        pokemonService.pokemonAttack();
    }

}
