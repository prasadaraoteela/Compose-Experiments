package com.experiments.coreui.di

import com.experiments.coreui.data.repository.DefaultNameRepository
import com.experiments.coreui.data.repository.NameRepository
import com.experiments.coreui.data.source.NameDataSource
import com.experiments.coreui.data.source.local.NameLocalDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Created by Prasada Rao on 28/01/22 11:28 PM
 **/
@Module
@InstallIn(SingletonComponent::class)
object CoreUiModule {

  @Provides
  fun getNameRepository(local: NameDataSource): NameRepository {
    return DefaultNameRepository(local)
  }

  @Provides
  fun getLocalNameDataSource(): NameDataSource {
    return NameLocalDataSource()
  }
}