package com.udemy.mealz.ui.meals

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.library.core.data.Result
import com.udemy.mealz.data.MealRepository
import com.udemy.mealz.data.model.MealCategory
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by Prasada Rao on 01/02/22 5:44 PM
 **/
@HiltViewModel
class MealCategoryViewModel @Inject constructor(
  private val repository: MealRepository
) : ViewModel() {

  fun observeMealCategories(): LiveData<Result<List<MealCategory>>> = liveData {
    emit(repository.fetchMealCategories())
  }
}