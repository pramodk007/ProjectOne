package com.example.projectone.ui.screen.fact

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.projectone.common.network.ApiException
import com.example.projectone.common.network.ApiResult
import com.example.projectone.core.BaseViewModel
import com.example.projectone.core.Resource
import com.example.projectone.domain.mapper.toFactModel
import com.example.projectone.domain.model.FactModel
import com.example.projectone.domain.usecase.FactUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FactViewModel @Inject constructor(private val factUseCase: FactUseCase) : BaseViewModel() {

    private var job: Job? = null

    private var _factLiveData = MutableLiveData<Resource<FactModel>>()
    val factLiveData get() = _factLiveData

    fun getFacts() {
        _factLiveData.value = Resource.loading()

        job = viewModelScope.launch {
            try {
                when (val response = factUseCase.invoke()) {
                    is ApiResult.Success -> {
                        _factLiveData.postValue(Resource.success(response.data.toFactModel()))
                    }
                    is ApiResult.Error -> {
                        _factLiveData.value = Resource.errorLogical(response.code, null)
                    }
                    is ApiResult.Exception ->{
                        _factLiveData.value = Resource.error(Exception(response.e),null)
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
                _factLiveData.value = Resource.error(e, null)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

}








