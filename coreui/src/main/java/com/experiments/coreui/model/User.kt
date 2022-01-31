package com.experiments.coreui.model

import androidx.annotation.DrawableRes

/**
 * Created by Prasada Rao on 30/01/22 11:27 AM
 **/
data class User(
  val id: Int,
  val name: String,
  val activeState: ActiveState = ActiveState.Online,
  @DrawableRes val profilePicture: Int,
  val imageUrl: String
) {

  enum class ActiveState {
    Online,
    Offline
  }
}
