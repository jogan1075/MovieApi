package com.jmc.domain.repository.mapper;

import com.jmc.data.entity.ResultsItem;
import com.jmc.domain.model.MovieModel;

import javax.inject.Inject;

public class MovieModelDomainToMovieEntityDataMapper extends Mapper<MovieModel, ResultsItem> {

    @Inject
    public MovieModelDomainToMovieEntityDataMapper() {
    }

    @Override
    public ResultsItem map(MovieModel value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public MovieModel reverseMap(ResultsItem value) {

        MovieModel movieModel = new MovieModel();
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