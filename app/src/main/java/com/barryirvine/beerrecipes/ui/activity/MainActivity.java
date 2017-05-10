package com.barryirvine.beerrecipes.ui.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.barryirvine.beerrecipes.App;
import com.barryirvine.beerrecipes.R;
import com.barryirvine.beerrecipes.databinding.ActivityMainBinding;
import com.barryirvine.beerrecipes.model.Beer;
import com.barryirvine.beerrecipes.ui.contract.MainContracts;
import com.barryirvine.beerrecipes.ui.fragment.BeerFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainContracts.View {

    @Inject
    MainContracts.Presenter mPresenter;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        ((App) getApplication()).getAppComponent().inject(this);
        mPresenter.attachView(this);
        setSupportActionBar(binding.toolbar);
    }


    public void addFragment(@IdRes final int containerViewId, final Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(containerViewId, fragment, fragment.getClass().getSimpleName()).commitNow();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.loadData();
    }

    @Override
    public void onDataLoaded(final List<Beer> beers) {
        addFragment(R.id.fragment_layout, BeerFragment.newInstance(new ArrayList<>(beers)));
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}