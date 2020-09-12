package com.android.propermanagement.room.property

import androidx.room.*
import com.android.propermanagement.room.property.PropertyCacheEntity

@Dao
interface PropertyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE )
    suspend fun insert(propertyCacheEntity: PropertyCacheEntity): Long

    @Query("SELECT * FROM properties")
    suspend fun getAll(): List<PropertyCacheEntity>

    @Delete
    suspend fun delete(propertyCacheEntity: PropertyCacheEntity)
}
