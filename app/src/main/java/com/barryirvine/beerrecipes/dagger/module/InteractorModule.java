package com.barryirvine.beerrecipes.dagger.module;

import com.barryirvine.beerrecipes.api.BeersAPI;
import com.barryirvine.beerrecipes.interactors.BeerData;
import com.barryirvine.beerrecipes.interactors.InteractorContracts;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class InteractorModule {
	@Provides
	@Singleton
	//TODO: Possibly add mapper
	InteractorContracts.BeerApi provideBeerData(final BeersAPI beersAPI) {
		return new BeerData(beersAPI);
	}
}
