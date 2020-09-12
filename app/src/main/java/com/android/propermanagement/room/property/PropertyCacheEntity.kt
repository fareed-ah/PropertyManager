package com.android.propermanagement.room.property

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "properties")
data class PropertyCacheEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "address")
    var address: String,

    @ColumnInfo(name = "bedrooms")
    var bedrooms: Int,

    @ColumnInfo(name = "bathrooms")
    var bathrooms: Int,

    @ColumnInfo(name = "imageUrl")
    var imageUrl: String
) {

}