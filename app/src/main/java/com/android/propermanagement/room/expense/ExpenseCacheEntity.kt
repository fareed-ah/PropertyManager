package com.android.propermanagement.room.expense

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "expenses")
data class ExpenseCacheEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "value")
    var value: Double,

    @ColumnInfo(name = "date")
    var date: String,

    @ColumnInfo(name = "property_street")
    var propertyStreet: String
) {

}