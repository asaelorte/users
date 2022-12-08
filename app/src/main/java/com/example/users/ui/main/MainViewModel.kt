package com.example.users.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.domain.User
import com.example.usecases.GetUserUseCase
import com.example.users.ui.common.ScopedViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val getUserUseCase: GetUserUseCase) :
    ScopedViewModel() {

    private val _model = MutableLiveData<UiModel>()

    val model: LiveData<UiModel>
        get() {
            if (_model.value == null) refresh()
            return _model
        }

    sealed class UiModel {
        object Loading : UiModel()
        class Content(val users: List<User>) : UiModel()
        object RequestLocationPermission : UiModel()
    }

    init {
        initScope()
    }

    private fun refresh() {
        _model.value = UiModel.RequestLocationPermission
    }

    fun getUsers() {
        launch {
            _model.value = UiModel.Loading
            _model.value = UiModel.Content(getUserUseCase.invoke())
        }
    }

    override fun onCleared() {
        destroyScope()
        super.onCleared()
    }
}