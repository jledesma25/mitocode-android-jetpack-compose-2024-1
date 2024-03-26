package com.mitocode.mitocodecoursecompose2024_i.presentation.dish

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mitocode.mitocodecoursecompose2024_i.core.Result
import com.mitocode.mitocodecoursecompose2024_i.data.repository.DishRepositoryImp
import com.mitocode.mitocodecoursecompose2024_i.domain.model.Dish
import com.mitocode.mitocodecoursecompose2024_i.domain.repository.DishRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DishViewModel @Inject constructor(val repository: DishRepository)  : ViewModel() {

    var state by mutableStateOf(DishState())
     private set

    fun getDishes(){

        //val repository : DishRepository = DishRepositoryImp()

        viewModelScope.launch {
            repository.getDishes().onEach {
                when(it){
                    is Result.Error -> {
                        state = state.copy(isLoading = false , error = it.message)
                    }
                    is Result.Loading -> {
                        state = state.copy(isLoading = true)
                    }
                    is Result.Success -> {
                        state = state.copy(isLoading = false, successfull = it.data)
                    }
                }
            }.launchIn(viewModelScope)
        }

    }
    
}