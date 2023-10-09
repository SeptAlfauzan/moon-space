package com.septalfauzan.moonspace.core.di.hilt

import com.septalfauzan.moonspace.core.data.RocketLaunchRepository
import com.septalfauzan.moonspace.core.domain.repository.IRocketLaunchRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRocketLaucnhRepository(rocketLaunchRepository: RocketLaunchRepository): IRocketLaunchRepository
}