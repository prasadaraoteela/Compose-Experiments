package com.experiments.coreui.data.source.local

import com.experiments.coreui.data.source.NameDataSource

/**
 * Created by Prasada Rao on 28/01/22 11:13 PM
 **/
class NameLocalDataSource : NameDataSource {

  private val names = ArrayList<String>()

  override fun fetchNames(): List<String> = names

  override fun addName(name: String) {
    names.add(name)
  }
}