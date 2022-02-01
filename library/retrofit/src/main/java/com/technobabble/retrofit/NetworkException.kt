package com.technobabble.retrofit

/**
 * Created by Prasada Rao on 31/01/22 8:12 PM
 **/
class NetworkException(
  val errorCode: Int,
  val errorMessage: String
): Exception()