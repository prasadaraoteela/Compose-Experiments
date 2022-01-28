package com.experiments.compose.cba.data.source.local

import android.content.Context
import com.experiments.compose.cba.data.source.AccountDataSource
import com.experiments.compose.data.model.AccountDetail
import com.experiments.compose.util.parse
import com.experiments.compose.util.readJsonAsset

class AccountLocalDataSource(
  private val applicationContext: Context
) : AccountDataSource {
  override suspend fun fetchAccountDetails(): AccountDetail {
    return applicationContext.readJsonAsset("exercise.json").parse()
  }
}