package com.android.propermanagement.di

import android.content.Context
import androidx.room.Room
import com.android.propermanagement.room.property.PropertyDao
import com.android.propermanagement.room.PropertyDatabase
import com.android.propermanagement.room.expense.ExpenseDao
import com.android.propermanagement.room.payment.PaymentDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object RoomModule {

    @Singleton
    @Provides
    fun providePropertiesDatabase(@ApplicationContext context: Context): PropertyDatabase {

        return Room.databaseBuilder(
            context,
            PropertyDatabase::class.java,
            PropertyDatabase.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun providePropertyDao(propertyDatabase: PropertyDatabase): PropertyDao {
        return propertyDatabase.propertyDao()
    }

    @Singleton
    @Provides
    fun provideExpenseDao(propertyDatabase: PropertyDatabase): ExpenseDao {
        return propertyDatabase.expenseDao()
    }

    @Singleton
    @Provides
    fun providePaymentDao(propertyDatabase: PropertyDatabase): PaymentDao {
        return propertyDatabase.paymentDao()
    }

}