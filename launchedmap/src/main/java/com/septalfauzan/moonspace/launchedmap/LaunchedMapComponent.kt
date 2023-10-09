package com.septalfauzan.moonspace.launchedmap

import android.content.Context
import com.septalfauzan.moonspace.di.LaunchedMapDependencies
import dagger.BindsInstance
import dagger.Component

@Component(dependencies = [LaunchedMapDependencies::class])
interface LaunchedMapComponent {
    fun inject(activity: LaunchedMapActivity)
    fun inject(fragment: MapsFragment)

    @Component.Builder
    interface Builder{
        fun context(@BindsInstance context: Context): Builder
        fun appDependencies(mapsModuleDependencies: LaunchedMapDependencies): Builder
        fun build(): LaunchedMapComponent
    }
}