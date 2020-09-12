package com.android.propermanagement.room.property

import com.android.propermanagement.model.Property
import com.android.propermanagement.util.EntityMapper
import javax.inject.Inject

class PropertyCacheMapper
    @Inject constructor() : EntityMapper<PropertyCacheEntity, Property>
{
    override fun mapFromEntity(entity: PropertyCacheEntity): Property {
        return Property(
            id = entity.id,
            address = entity.address,
            bedrooms = entity.bedrooms,
            bathrooms = entity.bathrooms,
            imageUrl = entity.imageUrl
        )
    }

    override fun mapToEntity(domainModel: Property): PropertyCacheEntity {
        return PropertyCacheEntity(
            id = domainModel.id,
            address = domainModel.address,
            bedrooms = domainModel.bedrooms,
            bathrooms = domainModel.bathrooms,
            imageUrl = domainModel.imageUrl
        )
    }

    fun mapFromEntityList(entities: List<PropertyCacheEntity>): List<Property> {
        return entities.map { mapFromEntity(it) }
    }
}