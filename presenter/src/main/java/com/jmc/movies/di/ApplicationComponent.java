package com.jmc.movies.di;

import android.app.Application;

import com.jmc.movies.MovieApplication;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = { ApplicationModule.class }) public interface ApplicationComponent {

    Application getApplication();

    void inject(MovieApplication movieApplication);
}
