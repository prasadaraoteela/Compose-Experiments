package com.technobabble.retrofit

import android.content.Context
import com.library.core.data.NetworkError
import okio.IOException
import retrofit2.HttpException
import retrofit2.Response
import java.net.SocketTimeoutException

/**
 * Created by Prasada Rao on 31/01/22 7:59 PM
 **/
interface NetworkFailureHandler {

  fun parseNetworkFailureException(
    applicationContext: Context,
    networkException: Throwable
  ): NetworkError {
    return when (networkException) {
      is HttpException -> {
        parseHttpException(applicationContext, networkException)
      }
      is SocketTimeoutException -> {
        NetworkError(
          NetworkResponseStatus.FailedWithSocketTimeOut.statusCode,
          applicationContext.getString(R.string.network_error_socket_connection_failure)
        )
      }

      is IOException -> {
        NetworkError(
          NetworkResponseStatus.FailedWithIOException.statusCode,
          applicationContext.getString(R.string.network_error_io_exception)
        )
      }

      else -> {
        NetworkError(
          NetworkResponseStatus.FailedWithUnknownReason.statusCode,
          applicationContext.getString(R.string.network_error_unknown)
        )
      }
    }
  }

  private fun parseHttpException(
    applicationContext: Context,
    httpException: HttpException
  ): NetworkError {
    return try {
      val networkResponse = getResponseFromHttpException(applicationContext, httpException)
      val errorBody = getErrorBodyFromResponse(applicationContext, networkResponse)
      NetworkError(httpException.code(), errorBody)
    } catch (exception: NetworkException) {
      NetworkError(exception.errorCode, exception.errorMessage)
    }
  }

  @Throws(NetworkException::class)
  private fun getResponseFromHttpException(
    applicationContext: Context,
    httpException: HttpException
  ): Response<*> {
    return httpException.response() ?: throw NetworkException(
      errorCode = NetworkResponseStatus.FailedWithNoResponseBody.statusCode,
      errorMessage = applicationContext.getString(R.string.network_error_no_response)
    )
  }

  @Throws(NetworkException::class)
  private fun getErrorBodyFromResponse(
    applicationContext: Context,
    response: Response<*>
  ): String {
    val errorBody = response.errorBody()?.string()

    if (errorBody.isNullOrBlank()) {
      throw NetworkException(
        errorCode = NetworkResponseStatus.FailedWithNoResponseBody.statusCode,
        errorMessage = applicationContext.getString(R.string.network_error_no_error_body)
      )
    }
    return errorBody
  }
}