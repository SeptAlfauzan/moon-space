package com.septalfauzan.moonspace.helper

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.septalfauzan.moonspace.core.domain.usecase.IUpcomingLaunchUseCase
import com.septalfauzan.moonspace.favorite.FavoriteViewModel
import javax.inject.Inject

class ViewModelFactory @Inject constructor(private val usecase: IUpcomingLaunchUseCase) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(FavoriteViewModel::class.java) -> {
                FavoriteViewModel(usecase) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
}