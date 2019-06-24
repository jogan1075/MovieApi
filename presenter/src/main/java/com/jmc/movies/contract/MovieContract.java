package com.jmc.movies.contract;

import com.jmc.movies.modelview.MovieModelView;
import com.jmc.movies.utils.commons.BasePresenter;

import java.util.List;

public interface MovieContract {


    interface View extends BasePresenter.View{
        void setMoviePopulatedItems(List<MovieModelView> movieItems);
        void setMovieMoreRatedItems(List<MovieModelView> movieItems);
    }

    interface Presenter {
        void loadMoviesPopulated();

        void loadMoviesMoreRated();
    }
}
