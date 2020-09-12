package com.android.propermanagement.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.android.propermanagement.room.expense.ExpenseCacheEntity
import com.android.propermanagement.room.expense.ExpenseDao
import com.android.propermanagement.room.payment.PaymentCacheEntity
import com.android.propermanagement.room.payment.PaymentDao
import com.android.propermanagement.room.property.PropertyCacheEntity
import com.android.propermanagement.room.property.PropertyDao

@Database(
    entities = [PropertyCacheEntity::class, ExpenseCacheEntity::class, PaymentCacheEntity::class],
    version = 3
)
abstract class PropertyDatabase : RoomDatabase() {
    abstract fun propertyDao(): PropertyDao

    abstract fun expenseDao(): ExpenseDao

    abstract fun paymentDao(): PaymentDao

    companion object {
        const val DATABASE_NAME: String = "property_db"
    }
}