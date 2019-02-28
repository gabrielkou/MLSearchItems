package com.gabrielkou.ml.injection.module

import com.gabrielkou.domain.executor.PostExecutionThread
import com.gabrielkou.ml.UiThread
import com.gabrielkou.ml.details.ItemDetailsActivity
import com.gabrielkou.ml.search.ItemListener
import com.gabrielkou.ml.search.SearchItemsActivity
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
abstract class UiModule {

    @Binds
    abstract fun bindPostExecutionThread(uiThread: UiThread): PostExecutionThread

    @ContributesAndroidInjector
    abstract fun contributesSearchItemsActivity(): SearchItemsActivity

    @ContributesAndroidInjector
    abstract fun contributeItemDetailsActivity(): ItemDetailsActivity
}