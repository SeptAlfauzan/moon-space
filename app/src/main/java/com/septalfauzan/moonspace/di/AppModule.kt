package com.septalfauzan.moonspace.di

import com.septalfauzan.moonspace.core.domain.usecase.IUpcomingLaunchUseCase
import com.septalfauzan.moonspace.core.domain.usecase.UpcomingLaunchInteractor
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {
    @Binds
    abstract fun provideUpcomingRocketLaunchUseCase(interactor: UpcomingLaunchInteractor): IUpcomingLaunchUseCase
}