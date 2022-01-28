package com.experiments.compose.cba.data

import com.experiments.compose.data.model.AccountDetail

/**
 * Created by Prasada Rao on 27/11/21 1:44 PM
 **/
interface AccountRepository {

  suspend fun fetchAccountDetails(): AccountDetail
}