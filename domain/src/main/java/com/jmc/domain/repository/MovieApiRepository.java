package com.jmc.domain.repository;

import com.jmc.data.datasource.MovieDataSource;
import com.jmc.data.entity.ResultsItem;
import com.jmc.domain.model.MovieModel;
import com.jmc.domain.repository.mapper.MovieModelDomainToMovieEntityDataMapper;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class MovieApiRepository implements MovieRepository {

    private MovieDataSource movieDataSource;
    private MovieModelDomainToMovieEntityDataMapper movieModelDomainToMovieEntityDataMapper;

    @Inject
    public MovieApiRepository(MovieDataSource movieDataSource, MovieModelDomainToMovieEntityDataMapper movieModelDomainToMovieEntityDataMapper) {
        this.movieDataSource = movieDataSource;
        this.movieModelDomainToMovieEntityDataMapper = movieModelDomainToMovieEntityDataMapper;
    }

    @Override
    public Observable<List<MovieModel>> getMoviesPopulated() {
        return movieDataSource.getMoviesPopulated().delay(2000, TimeUnit.MILLISECONDS)
                .map(new Function<List<ResultsItem>, List<MovieModel>>() {
                    @Override
                    public List<MovieModel> apply(List<ResultsItem> resultsItems) throws Exception {
                        return movieModelDomainToMovieEntityDataMapper.reverseMap(resultsItems);
                    }
                });
    }

    @Override
    public Observable<List<MovieModel>> getMoviesMoreRated() {
        return movieDataSource.getMoviesMoreRated().delay(2000, TimeUnit.MILLISECONDS)
                .map(new Function<List<ResultsItem>, List<MovieModel>>() {
                    @Override
                    public List<MovieModel> apply(List<ResultsItem> resultsItems) throws Exception {
                        return movieModelDomainToMovieEntityDataMapper.reverseMap(resultsItems);
                    }
                });
    }
}


