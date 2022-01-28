package com.experiments.coreui.di

import com.experiments.coreui.data.repository.NameRepository
import com.experiments.coreui.data.source.NameDataSource
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Created by Prasada Rao on 28/01/22 11:10 PM
 **/
@EntryPoint
@InstallIn(SingletonComponent::class)
interface CoreUiModuleDependencies {

  fun getLocalNameDataSource(): NameDataSource

  fun getNameRepository(): NameRepository
}