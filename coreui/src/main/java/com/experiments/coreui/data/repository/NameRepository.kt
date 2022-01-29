package com.experiments.coreui.data.repository

/**
 * Created by Prasada Rao on 28/01/22 11:12 PM
 **/
interface NameRepository {

  fun fetchNames(): List<String>

  fun addName(name: String)
}