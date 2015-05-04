package com.aranea_apps.android.samples.mvp.app.di;

import android.content.Context;
import android.location.LocationManager;

import com.aranea_apps.android.samples.mvp.app.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public final class ApplicationModule {
    private final App application;

    public ApplicationModule(App application) {
        this.application = application;
    }

    /**
     * Allow the application context to be injected but require that it be annotated with
     * {@link PerApplication @Annotation} to explicitly differentiate it from an activity context.
     */
    @Provides @Singleton
    @PerApplication
    Context provideApplicationContext() {
        return application;
    }

    @Provides @Singleton
    LocationManager provideLocationManager() {
        return (LocationManager) application.getSystemService(Context.LOCATION_SERVICE);
    }
}