package com.barryirvine.beerrecipes.api;


import com.barryirvine.beerrecipes.model.Beer;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface BeersAPI {

    String BASE_URL = "https://api.punkapi.com/v2/";

    @GET("beers?per_page=80")
    Observable<List<Beer>> getBeers();

}
