package com.jmc.domain.repository;

import com.jmc.domain.model.MovieModel;

import java.util.List;

import io.reactivex.Observable;

public interface MovieRepository {

    Observable<List<MovieModel>> getMoviesPopulated();

    Observable<List<MovieModel>> getMoviesMoreRated();
}
