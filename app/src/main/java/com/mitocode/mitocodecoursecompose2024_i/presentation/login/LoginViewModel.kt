package com.mitocode.mitocodecoursecompose2024_i.presentation.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mitocode.mitocodecoursecompose2024_i.core.Result
import com.mitocode.mitocodecoursecompose2024_i.data.model.UserDTO
import com.mitocode.mitocodecoursecompose2024_i.data.repository.LoginRepositoryImp
import com.mitocode.mitocodecoursecompose2024_i.domain.repository.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginViewModel : ViewModel() {

    var state by mutableStateOf(LoginState())

    fun signIn(email:String,password:String){

        val repository : LoginRepository = LoginRepositoryImp()


        viewModelScope.launch {
            repository.signIn(email,password).onEach {
                when(it){
                    is Result.Error -> {
                        //val isLoading:Boolean=false,
                        //val error:String?="el usuario no se encuentra",
                        //val successfull: UserDTO?=null
                        state = state.copy(error = it.message, isLoading = false)
                    }
                    is Result.Loading -> {
                        //val isLoading:Boolean=true,
                        //val error:String?=null,
                        //val successfull: UserDTO?=null
                        state = state.copy(isLoading = true)
                    }
                    is Result.Success -> {
                        state = state.copy(successfull = it.data, isLoading = false)
                    }
                }
            }.launchIn(viewModelScope)


        }



    }


}