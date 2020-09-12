package com.android.propermanagement.room.payment

import androidx.room.*
import com.android.propermanagement.room.expense.ExpenseCacheEntity

@Dao
interface PaymentDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE )
    suspend fun insert(paymentCacheEntity: PaymentCacheEntity): Long

    @Query("SELECT * FROM payments")
    suspend fun getAll(): List<PaymentCacheEntity>

    @Delete
    suspend fun delete(paymentCacheEntity: PaymentCacheEntity)
}
