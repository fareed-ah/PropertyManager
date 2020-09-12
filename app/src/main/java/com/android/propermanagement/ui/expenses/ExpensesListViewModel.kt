package com.android.propermanagement.ui.expenses

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.android.propermanagement.model.Expense
import com.android.propermanagement.repository.ExpenseRepository
import com.android.propermanagement.util.DataState
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch


class ExpensesListViewModel
@ViewModelInject
constructor(
    private val expenseRepository: ExpenseRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _dataState: MutableLiveData<DataState<List<Expense>>> = MutableLiveData()

    val dataState: LiveData<DataState<List<Expense>>>
        get() = _dataState

    fun setStateEvent(propertyListStateEvent: ExpenseListStateEvent) {
        viewModelScope.launch {
            when (propertyListStateEvent) {
                is ExpenseListStateEvent.GetExpenses -> {
                    expenseRepository.getExpenses().onEach {
                        _dataState.value = it
                    }.launchIn(viewModelScope)
                }
            }
        }
    }
}

sealed class ExpenseListStateEvent {
    object GetExpenses : ExpenseListStateEvent()

}