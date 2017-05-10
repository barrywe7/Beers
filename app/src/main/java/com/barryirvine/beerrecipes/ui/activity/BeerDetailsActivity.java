package com.barryirvine.beerrecipes.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;

import com.barryirvine.beerrecipes.App;
import com.barryirvine.beerrecipes.R;
import com.barryirvine.beerrecipes.databinding.ActivityBeerDetailsBinding;
import com.barryirvine.beerrecipes.model.Beer;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

public class BeerDetailsActivity extends AppCompatActivity {

    @Inject
    Picasso mPicasso;
    private ActivityBeerDetailsBinding mBinding;
    private Beer mBeer;

    public static void start(@NonNull final Context context, @NonNull final Beer beer, @Nullable final ActivityOptionsCompat options) {
        context.startActivity(makeIntent(context, beer), options != null ? options.toBundle() : null);
    }

    public static Intent makeIntent(@NonNull final Context context, final Beer beer) {
        return new Intent(context, BeerDetailsActivity.class)
                .putExtra(Extras.BEER, beer);
    }

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((App) getApplication()).getAppComponent().inject(this);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_beer_details);
        mBeer = getIntent().getParcelableExtra(Extras.BEER);
        setSupportActionBar(mBinding.toolbar);
        mPicasso.load(mBeer.getImageUrl()).into(mBinding.beerImageView);
        getSupportActionBar().setTitle(mBeer.getName());

    }

    private static class Extras {
        static final String BEER = Beer.class.getSimpleName();
    }
}
