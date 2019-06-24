package com.jmc.movies.observer;

import com.jmc.domain.common.UseCaseViewObserver;
import com.jmc.domain.model.MovieModel;
import com.jmc.movies.contract.MovieContract;
import com.jmc.movies.mapper.MovieModelViewPresenterToMovieModelDomainMapper;
import com.jmc.movies.modelview.MovieModelView;

import java.util.List;

import javax.inject.Inject;

public class MovieListPopulatedObserver extends UseCaseViewObserver<MovieContract.View, List<MovieModel>> {

    private MovieModelViewPresenterToMovieModelDomainMapper movieModelViewToMovieModelMapper;

    @Inject
    public MovieListPopulatedObserver(MovieModelViewPresenterToMovieModelDomainMapper movieModelViewToMovieModelMapper) {
        this.movieModelViewToMovieModelMapper = movieModelViewToMovieModelMapper;
    }

    @Override protected void onStart() {
        getView().showLoading();
    }

    @Override public void onComplete() {
        getView().hideLoading();
    }

    @Override public void onNext(List<MovieModel> movieModels) {

        List<MovieModelView> productViews = movieModelViewToMovieModelMapper.reverseMap(movieModels);
        getView().setMoviePopulatedItems(productViews);
    }

    @Override public void onError(Throwable e) {
        getView().hideLoading();
        getView().showConnectionError();
    }
}
