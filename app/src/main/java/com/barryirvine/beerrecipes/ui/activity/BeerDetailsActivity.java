package com.barryirvine.beerrecipes.ui.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.barryirvine.beerrecipes.R;
import com.barryirvine.beerrecipes.databinding.ActivityBeerDetailsBinding;

public class BeerDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityBeerDetailsBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_beer_details);
    }
}
