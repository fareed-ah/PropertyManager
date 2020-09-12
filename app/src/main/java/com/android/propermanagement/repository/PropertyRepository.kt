package com.android.propermanagement.repository

import com.android.propermanagement.model.Property
import com.android.propermanagement.room.property.PropertyCacheMapper
import com.android.propermanagement.room.property.PropertyCacheEntity
import com.android.propermanagement.room.property.PropertyDao
import com.android.propermanagement.util.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PropertyRepository
constructor(
    private val propertyDao: PropertyDao,
    private val propertyCacheMapper: PropertyCacheMapper
) {

    suspend fun getProperties(): Flow<DataState<List<Property>>> = flow {
        emit(DataState.Loading)
        propertyDao.insert(
            PropertyCacheEntity(
                id = 1,
                address = "34 willowdale dr",
                bathrooms = 2,
                bedrooms = 4,
                imageUrl = "some url"
            )
        )
        propertyDao.insert(
            PropertyCacheEntity(
                id = 2,
                address = "34 willowdale dr",
                bathrooms = 2,
                bedrooms = 4,
                imageUrl = "https://previews.123rf.com/images/iriana88w/iriana88w1409/iriana88w140901278/31999436-two-story-house-exterior-with-white-door-garage-and-driveway.jpg"
            )
        )
        propertyDao.insert(
            PropertyCacheEntity(
                id = 3,
                address = "34 willowdale dr",
                bathrooms = 2,
                bedrooms = 4,
                imageUrl = "https://previews.123rf.com/images/iriana88w/iriana88w1409/iriana88w140901278/31999436-two-story-house-exterior-with-white-door-garage-and-driveway.jpg"
            )
        )
        propertyDao.insert(
            PropertyCacheEntity(
                id = 4,
                address = "34 willowdale dr",
                bathrooms = 2,
                bedrooms = 4,
                imageUrl = "https://previews.123rf.com/images/iriana88w/iriana88w1409/iriana88w140901278/31999436-two-story-house-exterior-with-white-door-garage-and-driveway.jpg"
            )
        )
        try {
            val cachedProperties = propertyDao.getAll()
            emit(DataState.Success(propertyCacheMapper.mapFromEntityList(cachedProperties)))
        } catch (e: Exception) {
            emit(DataState.Error(e))
        }

    }
}