package com.cvcheck.di

import android.content.Context
import android.content.res.AssetManager
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideAssetManager(context: Context): AssetManager {
        return context.assets
    }
}