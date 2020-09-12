package com.android.propermanagement.room.payment

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "payments")
data class PaymentCacheEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "description")
    var description: String,

    @ColumnInfo(name = "value")
    var value: Double,

    @ColumnInfo(name = "due_date")
    var date: String,

    @ColumnInfo(name = "days_overdue")
    var days_overdue: Int,

    @ColumnInfo(name = "property_street")
    var propertyStreet: String
) {

}