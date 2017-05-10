package com.barryirvine.beerrecipes.interactors;

import com.barryirvine.beerrecipes.model.Beer;

import java.util.List;

import io.reactivex.Observable;

public interface InteractorContracts {
    interface BeerApi {
		Observable<List<Beer>> getBeers();
	}
}