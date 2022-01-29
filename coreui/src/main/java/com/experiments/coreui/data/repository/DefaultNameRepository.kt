package com.experiments.coreui.data.repository

import com.experiments.coreui.data.source.NameDataSource

class DefaultNameRepository(
  private val local: NameDataSource
) : NameRepository {

  override fun fetchNames(): List<String> = local.fetchNames()

  override fun addName(name: String) {
    local.addName(name)
  }
}