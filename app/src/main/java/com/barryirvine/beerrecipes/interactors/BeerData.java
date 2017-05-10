package com.barryirvine.beerrecipes.interactors;


import com.barryirvine.beerrecipes.api.BeersAPI;
import com.barryirvine.beerrecipes.model.Beer;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class BeerData implements InteractorContracts.BeerApi {
    private final BeersAPI mBeersAPI;

    public BeerData(final BeersAPI beersAPI) {
        mBeersAPI = beersAPI;
    }

    @Override
    public Observable<List<Beer>> getBeers() {
        return mBeersAPI.getBeers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
