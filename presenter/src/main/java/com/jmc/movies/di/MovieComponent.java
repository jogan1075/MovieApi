package com.jmc.movies.di;

import com.jmc.movies.ui.MainActivity;

import dagger.Component;

@ActivityScope @Component(modules = MovieModule.class, dependencies = ApplicationComponent.class)
public interface MovieComponent {

    void inject(MainActivity mainActivity);

}
