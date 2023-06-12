package com.ohgiraffers.section02.subsection05.inject;

import com.ohgiraffers.section02.common.Pokemon;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.inject.Named;

@Service("pokemonServiceInject")
public class PokemonService {

//    /* 1. 필드 주입 */
//    @Inject
//    @Named("pikachu")
//    private Pokemon pokemon;
//
//    public void pokemonAttack() {
//        pokemon.attack();
//    }

    /* 2. 생성자 주입 */
//    private Pokemon pokemon;
//
//    @Inject
//    public PokemonService(@Named("pikachu") Pokemon pokemon) {
//        this.pokemon = pokemon;
//    }
//
//    public void pokemonAttack() {
//        pokemon.attack();
//    }

    private Pokemon pokemon;
    /* 3. 세터 주입 */
    @Inject
    public void setPokemon(@Named("pikachu") Pokemon pokemon) {
        this.pokemon = pokemon;
    }
    public void pokemonAttack() {
        pokemon.attack();
    }


}

