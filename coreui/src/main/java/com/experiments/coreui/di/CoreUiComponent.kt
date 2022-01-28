package com.experiments.coreui.di

import android.content.Context
import com.experiments.coreui.CoreComposeUiActivity
import dagger.BindsInstance
import dagger.Component

/**
 * Created by Prasada Rao on 28/01/22 11:36 PM
 **/
@Component(dependencies = [CoreUiModuleDependencies::class])
interface CoreUiComponent {

  fun inject(activity: CoreComposeUiActivity)

  @Component.Builder
  interface Builder {

    fun context(@BindsInstance context: Context): Builder

    fun appDependencies(coreUiModuleDependencies: CoreUiModuleDependencies): Builder

    fun build(): CoreUiComponent
  }
}