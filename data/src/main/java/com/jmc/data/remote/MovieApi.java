package com.jmc.data.remote;

import com.jmc.data.entity.ResponseEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieApi {


    @GET("movie/popular")
    Observable<ResponseEntity> getMoviesPopulated(@Query("api_key") String apiKey);


    @GET("movie/top_rated")
    Observable<ResponseEntity> getMoviesTopRated(@Query("api_key") String apiKey);

}


//https://api.themoviedb.org/3/movie/popular?api_key=34738023d27013e6d1b995443764da44   -->popular

//https://api.themoviedb.org/3/movie/top_rated?api_key=34738023d27013e6d1b995443764da44     --->top rated