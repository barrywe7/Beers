package com.barryirvine.beerrecipes.ui.presenter;

import com.barryirvine.beerrecipes.interactors.InteractorContracts;
import com.barryirvine.beerrecipes.model.Beer;
import com.barryirvine.beerrecipes.ui.contract.MainContracts;

import java.util.List;

import io.reactivex.functions.Consumer;

public class MainPresenter implements MainContracts.Presenter {

    private final InteractorContracts.BeerApi mBeerApi;

    private MainContracts.View mView;

    public MainPresenter(final InteractorContracts.BeerApi beerApi) {
        mBeerApi = beerApi;
    }

    @Override
    public void attachView(final MainContracts.View view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }

    @Override
    public void loadData() {
        mBeerApi.getBeers()
                .subscribe(
                        new Consumer<List<Beer>>() {
                            @Override
                            public void accept(final List<Beer> beers) throws Exception {
                                if (mView != null && beers != null) {
                                    mView.onDataLoaded(beers);
                                }
                            }
                        },
                        new Consumer<Throwable>() {
                            @Override
                            public void accept(final Throwable throwable) throws Exception {
                                if (mView != null) {
                                    mView.showError("Error retrieving beers: " + throwable.getMessage());
                                }
                            }
                        });
    }
}