package com.pardeep.assisment.presentation.breeds

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pardeep.assisment.domain.breed.businessUseCase.GetBreedRandomImage
import com.pardeep.assisment.domain.common.base.BaseResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BreedFragmentViewModel @Inject constructor(
    private val breedRandomImage: GetBreedRandomImage
)  : ViewModel() {
    private val state = MutableStateFlow<CreateMainFragmentState>(CreateMainFragmentState.Init)
    val mState: StateFlow<CreateMainFragmentState> get() = state


    private fun setLoading(){
        state.value = CreateMainFragmentState.IsLoading(true)
    }

    private fun hideLoading(){
        state.value = CreateMainFragmentState.IsLoading(false)
    }

    private fun showToast(message: String){
        state.value = CreateMainFragmentState.ShowToast(message)
    }

    private fun successCreate(){
        state.value = CreateMainFragmentState.SuccessCreate
    }

    fun getDogImage(){

        viewModelScope.launch {
            breedRandomImage.invoke()
                .onStart {
                    setLoading()
                }
                .catch { exception ->
                    hideLoading()
                    showToast(exception.stackTraceToString())
                }
                .collect { result ->
                    hideLoading()
                    when(result){
                        is BaseResult.Success -> {
                            successCreate()
                        }
                        is BaseResult.Error -> showToast(result.rawResponse.message)
                    }
                }
        }
    }
}

sealed class CreateMainFragmentState {
    object Init: CreateMainFragmentState()
    object SuccessCreate : CreateMainFragmentState()
    data class IsLoading(val isLoading: Boolean) : CreateMainFragmentState()
    data class ShowToast(val message: String) : CreateMainFragmentState()
}