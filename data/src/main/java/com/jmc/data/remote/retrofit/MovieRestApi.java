package com.jmc.data.remote.retrofit;

import com.jmc.data.entity.ResponseEntity;

import io.reactivex.Observable;

public interface MovieRestApi {
    Observable<ResponseEntity> getMoviesPopulated();

    Observable<ResponseEntity> getMoviesMoreRated();
}
