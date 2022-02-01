package com.technobabble.retrofit

import android.content.Context
import com.library.core.data.Result

/**
 * Created by Prasada Rao on 31/01/22 6:56 PM
 **/
interface RemoteDataSource : NetworkFailureHandler {

  suspend fun <NetworkModel, DomainModel> prepareResult(
    applicationContext: Context,
    api: suspend () -> NetworkModel,
    dataConverter: (NetworkModel) -> DomainModel
  ): Result<DomainModel> {
    return try {
      Result.Success(dataConverter(api()))
    } catch (exception: Throwable) {
      Result.Failure(parseNetworkFailureException(applicationContext, exception))
    }
  }
}