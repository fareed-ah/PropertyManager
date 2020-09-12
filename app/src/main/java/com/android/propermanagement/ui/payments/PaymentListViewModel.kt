package com.android.propermanagement.ui.payments

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.android.propermanagement.model.Payment
import com.android.propermanagement.model.Property
import com.android.propermanagement.repository.PaymentRepository
import com.android.propermanagement.repository.PropertyRepository
import com.android.propermanagement.util.DataState
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class PaymentListViewModel
@ViewModelInject
constructor(
    private val paymentRepository: PaymentRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _dataState: MutableLiveData<DataState<List<Payment>>> = MutableLiveData()

    val dataState: LiveData<DataState<List<Payment>>>
        get() = _dataState

    fun setStateEvent(paymentListStateEvent: PaymentListStateEvent) {
        viewModelScope.launch {
            when (paymentListStateEvent) {
                is PaymentListStateEvent.GetPayments -> {
                    paymentRepository.getPayments().onEach {
                        _dataState.value = it
                    }.launchIn(viewModelScope)
                }
            }
        }
    }
}

sealed class PaymentListStateEvent {
    object GetPayments : PaymentListStateEvent()

}