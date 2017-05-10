package com.barryirvine.beerrecipes.ui.contract;

import java.util.List;
import com.barryirvine.beerrecipes.model.Beer;

public interface MainContracts {
    interface View {
        void onDataLoaded(List<Beer> beers);

        void showError(final String message);
    }

    interface Presenter {
        void attachView(final View view);

        void detachView();

        void loadData();
    }
}