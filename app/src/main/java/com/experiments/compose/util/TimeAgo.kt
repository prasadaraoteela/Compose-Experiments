package com.experiments.compose.util

import java.util.concurrent.TimeUnit

/**
 * Created by Prasada Rao on 26/11/21 3:03 PM
 **/
object TimeAgo {

  private val times = listOf(
    TimeUnit.DAYS.toMillis(365),
    TimeUnit.DAYS.toMillis(30),
    TimeUnit.DAYS.toMillis(1)
  )

  private val timeStrings = listOf(
    "years ago",
    "months ago",
    "days ago"
  )


}