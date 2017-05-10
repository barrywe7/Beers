package com.barryirvine.beerrecipes.dagger.component;

import com.barryirvine.beerrecipes.dagger.module.AppModule;
import com.barryirvine.beerrecipes.dagger.module.InteractorModule;
import com.barryirvine.beerrecipes.dagger.module.MainModule;
import com.barryirvine.beerrecipes.dagger.module.NetModule;
import com.barryirvine.beerrecipes.ui.activity.BeerDetailsActivity;
import com.barryirvine.beerrecipes.ui.activity.MainActivity;
import com.barryirvine.beerrecipes.ui.fragment.BeerFragment;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {AppModule.class, NetModule.class, InteractorModule.class, MainModule.class})
public interface AppComponent {
    void inject(final MainActivity activity);

    void inject(final BeerDetailsActivity activity);

    void inject(final BeerFragment fragment);
}
