package com.barryirvine.beerrecipes.ui.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.barryirvine.beerrecipes.App;
import com.barryirvine.beerrecipes.R;
import com.barryirvine.beerrecipes.databinding.FragmentBeerBinding;
import com.barryirvine.beerrecipes.model.Beer;
import com.barryirvine.beerrecipes.ui.adapter.BeerAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import javax.inject.Inject;

public class BeerFragment extends Fragment {

    @Inject
    Picasso mPicasso;
    private FragmentBeerBinding mBinding;
    private BeerAdapter mAdapter;
    private ArrayList<Beer> mBeers;

    public BeerFragment() {
    }

    public static BeerFragment newInstance(final ArrayList<Beer> beers) {
        final BeerFragment fragment = new BeerFragment();
        final Bundle args = new Bundle();
        args.putParcelableArrayList(Args.BEERS, beers);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((App) getActivity().getApplication()).getAppComponent().inject(this);
        mBeers = getArguments().getParcelableArrayList(Args.BEERS);
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_beer, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBinding = DataBindingUtil.bind(view);
        if (savedInstanceState == null) {
            mAdapter = new BeerAdapter(mBeers);
            mBinding.recyclerView.setAdapter(mAdapter);
        }
        mBinding.recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        if (((GridLayoutManager) mBinding.recyclerView.getLayoutManager()).getSpanCount() > 1) {
            mBinding.recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.HORIZONTAL));
        }
    }

    private class Args {
        private static final String BEERS = "BEERS";
    }

}
