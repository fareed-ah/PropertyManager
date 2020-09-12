package com.android.propermanagement.room.expense

import androidx.room.*
import com.android.propermanagement.room.expense.ExpenseCacheEntity

@Dao
interface ExpenseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE )
    suspend fun insert(expenseCacheEntity: ExpenseCacheEntity): Long

    @Query("SELECT * FROM expenses")
    suspend fun getAll(): List<ExpenseCacheEntity>

    @Delete
    suspend fun delete(expenseCacheEntity: ExpenseCacheEntity)
}
