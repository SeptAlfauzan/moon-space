package com.septalfauzan.moonspace.favorite

import android.content.Context
import com.septalfauzan.moonspace.di.FavoriteDependencies
import dagger.BindsInstance
import dagger.Component

@Component(dependencies = [FavoriteDependencies::class])
interface FavoriteComponent {
    fun inject(activity: FavoriteMainActivity)
    fun inject(fragment: FavoriteFragment)

    @Component.Builder
    interface Builder{
        fun context(@BindsInstance context: Context): Builder
        fun appDependencies(favoriteDependencies: FavoriteDependencies): Builder
        fun build(): FavoriteComponent
    }
}