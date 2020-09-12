package com.android.propermanagement.repository

import com.android.propermanagement.model.Expense
import com.android.propermanagement.room.expense.ExpenseCacheMapper
import com.android.propermanagement.room.expense.ExpenseDao
import com.android.propermanagement.util.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ExpenseRepository
constructor(
    private val expenseDao: ExpenseDao,
    private val expenseCacheMapper: ExpenseCacheMapper
) {

    suspend fun getExpenses(): Flow<DataState<List<Expense>>> = flow {
        emit(DataState.Loading)
        try {
            val cachedExpenses = expenseDao.getAll()
            emit(DataState.Success(expenseCacheMapper.mapFromEntityList(cachedExpenses)))
        } catch (e: Exception) {
            emit(DataState.Error(e))
        }

    }
}