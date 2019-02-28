package com.gabrielkou.ml.injection.module

import com.gabrielkou.domain.executor.PostExecutionThread
import com.gabrielkou.ml.UiThread
import com.gabrielkou.ml.search.SearchItemsActivity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class UiModule {

    @Binds
    abstract fun bindPostExecutionThread(uiThread: UiThread): PostExecutionThread

    @ContributesAndroidInjector
    abstract fun contributesSearchItemsActivity(): SearchItemsActivity

}