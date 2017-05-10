package com.barryirvine.beerrecipes.dagger.module;


import com.barryirvine.beerrecipes.interactors.InteractorContracts;
import com.barryirvine.beerrecipes.ui.presenter.MainPresenter;
import com.barryirvine.beerrecipes.ui.contract.MainContracts;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {
    @Provides
    @Singleton
    MainContracts.Presenter providePresenter(InteractorContracts.BeerApi beerApi) {
        return new MainPresenter(beerApi);
    }
}
