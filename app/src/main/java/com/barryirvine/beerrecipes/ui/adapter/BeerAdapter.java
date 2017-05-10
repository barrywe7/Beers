package com.barryirvine.beerrecipes.ui.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.barryirvine.beerrecipes.BR;
import com.barryirvine.beerrecipes.R;
import com.barryirvine.beerrecipes.model.Beer;
import com.barryirvine.beerrecipes.viewmodel.BeerViewModel;


import java.util.List;

public class BeerAdapter extends RecyclerView.Adapter<BeerAdapter.ViewHolder> {

    private final List<Beer> mItems;

    public BeerAdapter(final List<Beer> items) {
        mItems = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, @LayoutRes final int viewType) {
        return new BeerAdapter.ViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), viewType, parent, false));
    }

    @LayoutRes
    @Override
    public int getItemViewType(final int position) {
        return R.layout.item_beer;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.bind(new BeerViewModel(holder.itemView.getContext(), mItems.get(position)));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final ViewDataBinding mBinding;

        ViewHolder(@NonNull final ViewDataBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        void bind(@NonNull final BeerViewModel feedItemViewModel) {
            mBinding.setVariable(BR.viewModel, feedItemViewModel);
            mBinding.executePendingBindings();
        }
    }
}
