package com.jmc.movies.mapper;

import com.jmc.domain.model.MovieModel;
import com.jmc.domain.repository.mapper.Mapper;
import com.jmc.movies.modelview.MovieModelView;

import javax.inject.Inject;

public class MovieModelViewPresenterToMovieModelDomainMapper extends Mapper<MovieModelView, MovieModel> {

    @Inject
    public MovieModelViewPresenterToMovieModelDomainMapper() {
    }

    @Override
    public MovieModel map(MovieModelView value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public MovieModelView reverseMap(MovieModel value) {

        MovieModelView movieModel = new MovieModelView();
        movieModel.id = value.id;
        movieModel.overview = value.overview;
        movieModel.originalLanguage = value.originalLanguage;
        movieModel.originalTitle = value.originalTitle;
        movieModel.adult = value.adult;
        movieModel.backdropPath = value.backdropPath;
        movieModel.video = value.video;
        movieModel.title = value.title;
        movieModel.genreIds = value.genreIds;
        movieModel.posterPath = value.posterPath;
        movieModel.releaseDate = value.releaseDate;
        movieModel.voteAverage = value.voteAverage;
        movieModel.popularity = value.popularity;
        movieModel.voteCount = value.voteCount;


        return movieModel;
    }
}
