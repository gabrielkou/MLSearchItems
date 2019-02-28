package com.gabrielkou.ml.injection.module

import com.gabrielkou.data.ItemDataRepository
import com.gabrielkou.domain.repository.ItemsRepository
import dagger.Binds
import dagger.Module

@Module
abstract class DataModule {

    @Binds
    abstract fun bindDataRepository(dataRepository: ItemDataRepository): ItemsRepository
}