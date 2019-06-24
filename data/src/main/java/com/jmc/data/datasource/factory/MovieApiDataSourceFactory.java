package com.jmc.data.datasource.factory;

import com.jmc.data.datasource.MovieApiDataSource;
import com.jmc.data.remote.retrofit.MovieApiImp;

import javax.inject.Inject;

import io.reactivex.Scheduler;

public class MovieApiDataSourceFactory implements DataSourceFactory<MovieApiDataSource> {

    private Scheduler scheduler;

    @Inject
    public MovieApiDataSourceFactory(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    @Override
    public MovieApiDataSource createDataSource() {
        return new MovieApiDataSource(new MovieApiImp(scheduler));
    }
}
