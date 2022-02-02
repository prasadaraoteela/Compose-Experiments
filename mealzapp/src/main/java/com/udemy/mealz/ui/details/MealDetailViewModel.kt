package com.udemy.mealz.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.udemy.mealz.data.MealRepository
import com.udemy.mealz.data.model.MealCategory
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by Prasada Rao on 02/02/22 9:25 PM
 **/
@HiltViewModel
class MealDetailViewModel @Inject constructor(
  private val repository: MealRepository
) : ViewModel() {

  fun getMealCategoryById(mealCategoryId: String): LiveData<MealCategory> = liveData {
    emit(repository.findMealCategoryById(mealCategoryId = mealCategoryId))
  }
}