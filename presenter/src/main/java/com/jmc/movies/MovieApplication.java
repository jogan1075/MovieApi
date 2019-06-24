package com.jmc.movies;

import android.app.Application;

import com.jmc.movies.di.ApplicationComponent;
import com.jmc.movies.di.ApplicationModule;
import com.jmc.movies.di.DaggerApplicationComponent;

public class MovieApplication extends Application {

    private static ApplicationComponent applicationComponent;

    @Override public void onCreate() {
        super.onCreate();
        applicationComponent =
                DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();

        applicationComponent.inject(this);
    }

    public static ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
