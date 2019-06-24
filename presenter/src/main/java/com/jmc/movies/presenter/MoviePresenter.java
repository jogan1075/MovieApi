package com.jmc.movies.presenter;

import com.jmc.domain.usercases.GetMoviesMoreRatedUseCase;
import com.jmc.domain.usercases.GetMoviesPopulatedUseCase;
import com.jmc.movies.contract.MovieContract;
import com.jmc.movies.mapper.MovieModelViewPresenterToMovieModelDomainMapper;
import com.jmc.movies.observer.MovieListMoreRatedObserver;
import com.jmc.movies.observer.MovieListPopulatedObserver;
import com.jmc.movies.utils.commons.BasePresenter;

import javax.inject.Inject;

public class MoviePresenter extends BasePresenter<MovieContract.View>
        implements MovieContract.Presenter {


    private GetMoviesPopulatedUseCase getMoviesPopulatedUseCase;
    private GetMoviesMoreRatedUseCase getMoviesMoreRatedUseCase;

    private MovieModelViewPresenterToMovieModelDomainMapper movieModelViewPresenterToMovieModelDomainMapper;

    private MovieListMoreRatedObserver movieListMoreRatedObserver;
    private MovieListPopulatedObserver movieListPopulatedObserver;

    @Inject
    public MoviePresenter(GetMoviesPopulatedUseCase getMoviesPopulatedUseCase,
                          GetMoviesMoreRatedUseCase getMoviesMoreRatedUseCase,
                          MovieModelViewPresenterToMovieModelDomainMapper movieModelViewPresenterToMovieModelDomainMapper) {
        this.getMoviesPopulatedUseCase = getMoviesPopulatedUseCase;
        this.getMoviesMoreRatedUseCase = getMoviesMoreRatedUseCase;
        this.movieModelViewPresenterToMovieModelDomainMapper = movieModelViewPresenterToMovieModelDomainMapper;
    }


    @Override
    public void loadMoviesPopulated() {
        movieListPopulatedObserver = new MovieListPopulatedObserver(movieModelViewPresenterToMovieModelDomainMapper);
        movieListPopulatedObserver.attachView(getView());
        getMoviesPopulatedUseCase.execute(movieListPopulatedObserver);
    }

    @Override
    public void loadMoviesMoreRated() {
        movieListMoreRatedObserver = new MovieListMoreRatedObserver(movieModelViewPresenterToMovieModelDomainMapper);
        movieListMoreRatedObserver.attachView(getView());
        getMoviesMoreRatedUseCase.execute(movieListMoreRatedObserver);
    }
}
