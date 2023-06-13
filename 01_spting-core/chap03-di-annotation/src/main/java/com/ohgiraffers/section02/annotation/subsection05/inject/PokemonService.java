package com.ohgiraffers.section02.annotation.subsection05.inject;

import com.ohgiraffers.section02.common.Pokemon;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.inject.Named;

@Service("pokemonServiceInject")
public class PokemonService {

    /* 1. 필드 주입 */
    @Inject
    @Named("pikachu")
    private Pokemon pokemon;

    /* 2. 생성자 주입 */
//	@Inject
//	// @Named의 경우 메소드 레벨, 파라미터 레벨에서 사용 가능
//	public PokemonService(@Named("pikachu") Pokemon pokemon) {
//		this.pokemon = pokemon;
//	}

    /* 3. 세터 주입 */
//	@Inject
//	public void setPokemon(@Named("pikachu") Pokemon pokemon) {
//		this.pokemon = pokemon;
//	}

    public void pokemonAttack() {
        pokemon.attack();
    }


}