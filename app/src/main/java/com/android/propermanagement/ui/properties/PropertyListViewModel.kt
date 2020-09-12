package com.android.propermanagement.ui.properties

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.android.propermanagement.model.Property
import com.android.propermanagement.repository.PropertyRepository
import com.android.propermanagement.util.DataState
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class PropertyListViewModel
@ViewModelInject
constructor(
    private val propertyRepository: PropertyRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _dataState: MutableLiveData<DataState<List<Property>>> = MutableLiveData()

    val dataState: LiveData<DataState<List<Property>>>
        get() = _dataState

    fun setStateEvent(propertyListStateEvent: PropertyListStateEvent) {
        viewModelScope.launch {
            when (propertyListStateEvent) {
                is PropertyListStateEvent.GetProperties -> {
                    propertyRepository.getProperties().onEach {
                        _dataState.value = it
                    }.launchIn(viewModelScope)
                }
            }
        }
    }
}

sealed class PropertyListStateEvent {
    object GetProperties : PropertyListStateEvent()

}