package com.septalfauzan.moonspace.di

import com.septalfauzan.moonspace.core.domain.usecase.IUpcomingLaunchUseCase
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface LaunchedMapDependencies {
    fun provideUpComingUseCase(): IUpcomingLaunchUseCase
}