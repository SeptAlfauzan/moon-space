package com.septalfauzan.moonspace.di

import com.septalfauzan.moonspace.core.domain.usecase.InterfaceUpcomingLaunchUseCase
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface FavoriteDependencies {
    fun provideUpComingUseCase(): InterfaceUpcomingLaunchUseCase
}