package com.android.propermanagement.repository

import com.android.propermanagement.model.Payment
import com.android.propermanagement.room.payment.PaymentCacheMapper
import com.android.propermanagement.room.payment.PaymentDao
import com.android.propermanagement.util.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PaymentRepository
constructor(
    private val paymentDao: PaymentDao,
    private val paymentCacheMapper: PaymentCacheMapper
) {

    suspend fun getPayments(): Flow<DataState<List<Payment>>> = flow {
        emit(DataState.Loading)
        try {
            val cachedPayments = paymentDao.getAll()
            emit(DataState.Success(paymentCacheMapper.mapFromEntityList(cachedPayments)))
        } catch (e: Exception) {
            emit(DataState.Error(e))
        }

    }
}