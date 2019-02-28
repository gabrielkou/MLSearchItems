package com.gabrielkou.ml.injection.module

import com.gabrielkou.data.repository.ItemsRemote
import com.gabrielkou.ml.BuildConfig
import com.gabrielkou.remote.ItemsRemoteImpl
import com.gabrielkou.remote.service.ItemsService
import com.gabrielkou.remote.service.SearchServiceFactory
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class RemoteModule {

    @Module
    companion object {
        @Provides
        @JvmStatic
        fun provideSearchService(): ItemsService {
            return SearchServiceFactory.makeSearchService(BuildConfig.DEBUG)
        }
    }

    @Binds
    abstract fun bindItemsRemote(itemsRemote: ItemsRemoteImpl): ItemsRemote
}