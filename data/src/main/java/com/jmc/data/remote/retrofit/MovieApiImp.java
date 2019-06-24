package com.jmc.data.remote.retrofit;

import com.jmc.data.entity.ResponseEntity;
import com.jmc.data.remote.MovieApi;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

import static com.jmc.data.remote.Constants.API_KEY;
import static com.jmc.data.remote.Constants.URL_BASE;

public class MovieApiImp extends RetrofitApiClient<MovieApi> implements MovieRestApi {

    private Scheduler scheduler;

    public MovieApiImp(Scheduler scheduler) {
        this.scheduler = scheduler;
    }


    @Override
    protected Class<MovieApi> getApiService() {
        return MovieApi.class;
    }

    @Override
    protected String getBaseURL() {
        return URL_BASE;
    }


    @Override
    public Observable<ResponseEntity> getMoviesPopulated() {
        return apiService.getMoviesPopulated(API_KEY).subscribeOn(Schedulers.io())
                .observeOn(scheduler);
    }

    @Override
    public Observable<ResponseEntity> getMoviesMoreRated() {
        return apiService.getMoviesTopRated(API_KEY).subscribeOn(Schedulers.io())
                .observeOn(scheduler);
    }
}
