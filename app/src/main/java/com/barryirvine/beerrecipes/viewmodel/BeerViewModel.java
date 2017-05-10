package com.barryirvine.beerrecipes.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.annotation.NonNull;

import com.barryirvine.beerrecipes.model.Beer;
import com.barryirvine.beerrecipes.ui.activity.BeerDetailsActivity;

/**
 * View Model for {@link Beer} Remember to use the {@link Bindable} annotation for all getters and to do
 * {@link #notifyPropertyChanged(int)} after a value is set in a setter.
 */

public class BeerViewModel extends BaseObservable {

    private final Context mContext;
    private final Beer mBeer;


    public BeerViewModel(@NonNull final Context context, final Beer beer) {
        mContext = context;
        mBeer = beer;
    }

    @Bindable
    public String getName() {
        return mBeer.getName();
    }

    @Bindable
    public String getDescription() {
        return mBeer.getDescription();
    }

    @Bindable
    public String getAbv() {
        return String.valueOf(mBeer.getAbv()) +"%";
    }

    @Bindable
    public String getTagline() {
        return mBeer.getTagline();
    }

    @Bindable
    public String getImageUrl() {
        return mBeer.getImageUrl();
    }

    public void onClick() {
        // Haven't worked out a safe way of passing the view from view model for use in the shared transitions yet
        BeerDetailsActivity.start(mContext, mBeer, null);
    }
}