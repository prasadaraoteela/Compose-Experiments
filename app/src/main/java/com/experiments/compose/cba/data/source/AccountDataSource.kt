package com.experiments.compose.cba.data.source

import com.experiments.compose.data.model.AccountDetail

/**
 * Created by Prasada Rao on 27/11/21 1:41 PM
 **/
interface AccountDataSource {

  suspend fun fetchAccountDetails(): AccountDetail
}