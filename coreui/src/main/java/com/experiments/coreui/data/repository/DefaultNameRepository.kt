package com.experiments.coreui.data.repository

import androidx.lifecycle.LiveData
import com.experiments.coreui.data.source.NameDataSource

class DefaultNameRepository(
  private val local: NameDataSource
) : NameRepository {

  override fun fetchNames(): List<String> = local.fetchNames()

  override fun addName(name: String) {
    local.addName(name)
  }

  override fun observeNames(): LiveData<List<String>> = local.observeNames()
}