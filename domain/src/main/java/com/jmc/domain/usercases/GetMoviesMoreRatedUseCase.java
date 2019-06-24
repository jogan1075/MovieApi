package com.jmc.domain.usercases;

import com.jmc.domain.common.UseCase;
import com.jmc.domain.model.MovieModel;
import com.jmc.domain.repository.MovieRepository;

import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Scheduler;

public class GetMoviesMoreRatedUseCase extends UseCase<List<MovieModel>> {

    private MovieRepository movieRepository;

    @Inject
    public GetMoviesMoreRatedUseCase(MovieRepository movieRepository, Scheduler scheduler) {
        super(scheduler);
        this.movieRepository = movieRepository;
    }

    @Override
    protected Observable<List<MovieModel>> buildUseCaseObservable() {

        return movieRepository.getMoviesMoreRated();
    }
}
