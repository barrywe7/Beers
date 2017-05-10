package com.barryirvine.beerrecipes.ui;

import android.databinding.BindingAdapter;
import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.barryirvine.beerrecipes.R;
import com.squareup.picasso.Picasso;

public class DataBindingUtils {

    @BindingAdapter({"imageUrl"})
    public static void loadImage(@NonNull final ImageView view, @NonNull final String imageUrl) {
        Picasso.with(view.getContext())
                .load(imageUrl)
                .resizeDimen(R.dimen.thumbnail_width, R.dimen.thumbnail_height)
                .placeholder(R.drawable.ic_image_grey_24dp)
                .centerInside()
                .into(view);
    }
}
