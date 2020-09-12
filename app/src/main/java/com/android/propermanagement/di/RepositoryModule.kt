package com.android.propermanagement.di

import com.android.propermanagement.repository.ExpenseRepository
import com.android.propermanagement.repository.PaymentRepository
import com.android.propermanagement.repository.PropertyRepository
import com.android.propermanagement.room.expense.ExpenseCacheMapper
import com.android.propermanagement.room.expense.ExpenseDao
import com.android.propermanagement.room.payment.PaymentCacheMapper
import com.android.propermanagement.room.payment.PaymentDao
import com.android.propermanagement.room.property.PropertyCacheMapper
import com.android.propermanagement.room.property.PropertyDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun providesPropertyRepository(
        propertyDao: PropertyDao,
        propertyCacheMapper: PropertyCacheMapper
    ): PropertyRepository {
        return PropertyRepository(
            propertyDao,
            propertyCacheMapper
        )
    }

    @Singleton
    @Provides
    fun providesExpenseRepository(
        expenseDao: ExpenseDao,
        expenseCacheMapper: ExpenseCacheMapper
    ): ExpenseRepository {
        return ExpenseRepository(
            expenseDao,
            expenseCacheMapper
        )
    }

    @Singleton
    @Provides
    fun providesPaymentRepository(
        paymentDao: PaymentDao,
        paymentCacheMapper: PaymentCacheMapper
    ): PaymentRepository {
        return PaymentRepository(
            paymentDao,
            paymentCacheMapper
        )
    }

}