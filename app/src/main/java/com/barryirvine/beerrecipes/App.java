package com.barryirvine.beerrecipes;

import android.app.Application;

import com.barryirvine.beerrecipes.api.BeersAPI;
import com.barryirvine.beerrecipes.dagger.component.AppComponent;
import com.barryirvine.beerrecipes.dagger.component.DaggerAppComponent;
import com.barryirvine.beerrecipes.dagger.module.AppModule;
import com.barryirvine.beerrecipes.dagger.module.NetModule;

public class App extends Application {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        //TODO: Add baseUrl
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule(BeersAPI.BASE_URL))
                .build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
