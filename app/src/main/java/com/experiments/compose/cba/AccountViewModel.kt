package com.experiments.compose.cba

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.experiments.compose.cba.data.AccountRepository
import com.experiments.compose.data.model.AccountDetail

/**
 * Created by Prasada Rao on 27/11/21 1:41 PM
 **/
class AccountViewModel(
  private val repository: AccountRepository
) : ViewModel() {

  fun fetchAccountDetails(): LiveData<AccountDetail> = liveData {
    emit(repository.fetchAccountDetails())
  }

}