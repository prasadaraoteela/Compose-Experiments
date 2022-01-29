package com.experiments.coreui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.experiments.coreui.data.repository.NameRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by Prasada Rao on 29/01/22 10:04 AM
 **/
@HiltViewModel
class CoreUiViewModel @Inject constructor(
  private val repository: NameRepository
): ViewModel() {

  private val namesLiveData = MutableLiveData<List<String>>()

  fun addName(name: String) {
    repository.addName(name)
    namesLiveData.postValue(ArrayList(repository.fetchNames()))
  }

  fun observeNames(): LiveData<List<String>> = namesLiveData
}