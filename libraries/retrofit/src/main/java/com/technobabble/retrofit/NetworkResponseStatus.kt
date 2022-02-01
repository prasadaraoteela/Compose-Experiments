package com.technobabble.retrofit

/**
 * Created by Prasada Rao on 31/01/22 8:04 PM
 **/
enum class NetworkResponseStatus(val statusCode: Int) {
  Success(statusCode = 200),
  FailedWithNoInternet(statusCode = 500),
  FailedWithNoResponseBody(statusCode = 501),
  FailedWithSocketTimeOut(statusCode = 502),
  FailedWithIOException(statusCode = 503),
  FailedWithUnknownReason(statusCode = 504),
}