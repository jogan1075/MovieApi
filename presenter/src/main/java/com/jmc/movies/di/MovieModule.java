package com.jmc.movies.di;

import com.jmc.data.datasource.factory.MovieApiDataSourceFactory;
import com.jmc.domain.repository.MovieApiRepository;
import com.jmc.domain.repository.MovieRepository;
import com.jmc.domain.repository.mapper.MovieModelDomainToMovieEntityDataMapper;
import com.jmc.domain.usercases.GetMoviesMoreRatedUseCase;
import com.jmc.domain.usercases.GetMoviesPopulatedUseCase;
import com.jmc.movies.mapper.MovieModelViewPresenterToMovieModelDomainMapper;
import com.jmc.movies.observer.MovieListMoreRatedObserver;
import com.jmc.movies.observer.MovieListPopulatedObserver;
import com.jmc.movies.presenter.MoviePresenter;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;

@Module
public class MovieModule {


    @Provides
    public MovieModelDomainToMovieEntityDataMapper provideMovieModelDomainToMovieEntityDataMapper() {
        return new MovieModelDomainToMovieEntityDataMapper();
    }

    @Provides
    public MovieModelViewPresenterToMovieModelDomainMapper provideMovieModelViewPresenterToMovieModelDomainMapper() {
        return new MovieModelViewPresenterToMovieModelDomainMapper();
    }

    @Provides
    public MovieApiDataSourceFactory provideMovieApiDataSourceFactory(Scheduler scheduler) {
        return new MovieApiDataSourceFactory(scheduler);
    }

    @Provides
    public MovieRepository provideMovieRepository(MovieApiDataSourceFactory movieApiDataSourceFactory,
                                                  MovieModelDomainToMovieEntityDataMapper provideMovieModelDomainToMovieEntityDataMapper) {
        return new MovieApiRepository(movieApiDataSourceFactory.createDataSource(),
                provideMovieModelDomainToMovieEntityDataMapper);
    }

    @Provides
    public Scheduler provideAndroidProvide() {
        return AndroidSchedulers.mainThread();
    }

    @Provides
    public GetMoviesMoreRatedUseCase provideGetMoviesMoreRatedUseCase(MovieRepository movieRepository,
                                                                      Scheduler scheduler) {
        return new GetMoviesMoreRatedUseCase(movieRepository, scheduler);
    }

    @Provides
    public GetMoviesPopulatedUseCase provideGetMoviesPopulatedUseCase(MovieRepository movieRepository, Scheduler scheduler) {
        return new GetMoviesPopulatedUseCase(movieRepository, scheduler);
    }

    @Provides
    public MoviePresenter provideMoviePresenter(GetMoviesPopulatedUseCase getMoviesPopulatedUseCase, GetMoviesMoreRatedUseCase getMoviesMoreRatedUseCase,
                                                MovieModelViewPresenterToMovieModelDomainMapper movieModelViewPresenterToMovieModelDomainMapper) {
        return new MoviePresenter(getMoviesPopulatedUseCase, getMoviesMoreRatedUseCase, movieModelViewPresenterToMovieModelDomainMapper);
    }

    @Provides
    public MovieListMoreRatedObserver provideMovieListMoreRatedObserver(
            MovieModelViewPresenterToMovieModelDomainMapper movieModelViewPresenterToMovieModelDomainMapper) {
        return new MovieListMoreRatedObserver(movieModelViewPresenterToMovieModelDomainMapper);
    }

    @Provides
    public MovieListPopulatedObserver provideMovieListPopulatedObserver(
            MovieModelViewPresenterToMovieModelDomainMapper movieModelViewPresenterToMovieModelDomainMapper) {
        return new MovieListPopulatedObserver(movieModelViewPresenterToMovieModelDomainMapper);
    }
}
