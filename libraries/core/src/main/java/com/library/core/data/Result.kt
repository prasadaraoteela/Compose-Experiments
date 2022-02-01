package com.library.core.data

/**
 * Created by Prasada Rao on 31/01/22 6:46 PM
 **/
sealed class Result<Data> {

  data class Success<Data>(val data: Data) : Result<Data>()

  data class Failure<Data>(val error: NetworkError) : Result<Data>()
}
