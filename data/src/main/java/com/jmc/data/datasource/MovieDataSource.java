package com.jmc.data.datasource;

import com.jmc.data.entity.ResponseEntity;
import com.jmc.data.entity.ResultsItem;

import java.util.List;

import io.reactivex.Observable;

public interface MovieDataSource {


    Observable<List<ResultsItem>> getMoviesPopulated();

    Observable<List<ResultsItem>> getMoviesMoreRated();
}
