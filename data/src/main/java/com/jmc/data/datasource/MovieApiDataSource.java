package com.jmc.data.datasource;

import com.jmc.data.entity.ResponseEntity;
import com.jmc.data.entity.ResultsItem;
import com.jmc.data.remote.retrofit.MovieRestApi;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class MovieApiDataSource implements MovieDataSource {

    private MovieRestApi movieRestApi;

    @Inject
    public MovieApiDataSource(MovieRestApi movieRestApi) {
        this.movieRestApi = movieRestApi;
    }

    @Override
    public Observable<List<ResultsItem>> getMoviesPopulated() {
        return movieRestApi.getMoviesPopulated().map(new Function<ResponseEntity, List<ResultsItem>>() {
            @Override
            public List<ResultsItem> apply(ResponseEntity responseEntity) throws Exception {
                return responseEntity.results;
            }
        });
    }

    @Override
    public Observable<List<ResultsItem>> getMoviesMoreRated() {
        return movieRestApi.getMoviesMoreRated().map(new Function<ResponseEntity, List<ResultsItem>>() {
            @Override
            public List<ResultsItem> apply(ResponseEntity responseEntity) throws Exception {
                return responseEntity.results;
            }
        });
    }
}
