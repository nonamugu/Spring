package com.ohgiraffers.section02.subsection04.resource;

import com.ohgiraffers.section02.common.Pokemon;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("pokemonServiceResource")
public class PokemonService {

//    /* pikachu 이름의 빈 지정 */
//    @Resource(name="pikachu")
//    private Pokemon pokemon;
//
//    public void pokemonAttack() {
//        pokemon.attack();
//    }

    /* 타입으로 주입 */
    @Resource
    private List<Pokemon> pokemonList;

    public void pokemonAttack() {
        pokemonList.forEach(Pokemon::attack);
    }

}

