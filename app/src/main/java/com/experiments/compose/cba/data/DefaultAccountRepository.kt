package com.experiments.compose.cba.data

import com.experiments.compose.cba.data.source.AccountDataSource
import com.experiments.compose.data.model.AccountDetail

class DefaultAccountRepository(
  private val local: AccountDataSource
) : AccountRepository {
  override suspend fun fetchAccountDetails(): AccountDetail {
    return local.fetchAccountDetails()
  }
}