package com.gabrielkou.ml.injection.module

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.gabrielkou.ml.injection.ViewModelFactory
import com.gabrielkou.presentation.details.ItemDetailsViewModel
import com.gabrielkou.presentation.search.SearchItemsViewModel
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass

@Module
abstract class PresentationModule {

    @Binds
    @IntoMap
    @ViewModelKey(SearchItemsViewModel::class)
    abstract fun bindSearchItemsViewModel(viewModel: SearchItemsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ItemDetailsViewModel::class)
    abstract fun bindItemDetailsViewModel(
        viewModel: ItemDetailsViewModel): ViewModel


    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}

@MustBeDocumented
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)