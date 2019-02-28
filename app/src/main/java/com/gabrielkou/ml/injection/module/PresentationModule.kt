package com.gabrielkou.ml.injection.module

import android.arch.lifecycle.ViewModel
import com.gabrielkou.presentation.SearchItemsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class PresentationModule {

    @Binds
//    @IntoMap
//    @ViewModelKey(BrowseProjectsViewModel::class)
    abstract fun bindSearchItemsViewModel(viewModel: SearchItemsViewModel): ViewModel

//    @Binds
//    @IntoMap
//    @ViewModelKey(BrowseBookmarkedProjectsViewModel::class)
//    abstract fun bindBrowseBookmarkedProjectsViewModel(
//        viewModel: BrowseBookmarkedProjectsViewModel): ViewModel


//    @Binds
//    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}

//@MustBeDocumented
//@Target(AnnotationTarget.FUNCTION)
//@Retention(AnnotationRetention.RUNTIME)
//@MapKey
//annotation class ViewModelKey(val value: KClass<out ViewModel>)