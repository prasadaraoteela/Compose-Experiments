package com.experiments.coreui.data.source

import androidx.lifecycle.LiveData

/**
 * Created by Prasada Rao on 28/01/22 11:13 PM
 **/
interface NameDataSource {

  fun fetchNames(): List<String>

  fun addName(name: String)

  fun observeNames(): LiveData<List<String>>
}