package com.ohgiraffers.section02.annotation.subsection03.collection;

import java.util.List;
import java.util.Map;

import com.ohgiraffers.section02.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("pokemonServiceCollection")
public class PokemonService {

    /* 1. List 타입으로 주입  */
/*	private List<Pokemon> pokemonList;

	@Autowired
	public PokemonService(List<Pokemon> pokemonList) {
		this.pokemonList = pokemonList;
	}

	public void pokemonAttack() {
		pokemonList.forEach(Pokemon::attack);
	}*/


    /* bean 이름의 사전순으로 List에 추가 되어 모든 Pokemon 타입의 빈이 주입 된다. */

    /* 2. Map 타입으로 주입 */
    private Map<String, Pokemon> pokemonMap;

    @Autowired
    public PokemonService(Map<String, Pokemon> pokemonMap) {
        this.pokemonMap = pokemonMap;
    }

    public void pokemonAttack() {
        pokemonMap.forEach((k, v) -> {
            System.out.println("key : " + k);
            System.out.print("공격 : ");
            v.attack();
        });
    }

}




