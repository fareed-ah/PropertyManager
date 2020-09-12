package com.android.propermanagement.room.expense

import com.android.propermanagement.model.Expense
import com.android.propermanagement.util.EntityMapper
import java.sql.Date
import javax.inject.Inject

class ExpenseCacheMapper
@Inject constructor() : EntityMapper<ExpenseCacheEntity, Expense> {
    override fun mapFromEntity(entity: ExpenseCacheEntity): Expense {
        return Expense(
            id = entity.id,
            name = entity.name,
            propertyStreet = entity.propertyStreet,
            value = entity.value,
            date = Date.valueOf(entity.date)
        )
    }

    override fun mapToEntity(domainModel: Expense): ExpenseCacheEntity {
        return ExpenseCacheEntity(
            id = domainModel.id,
            name = domainModel.name,
            propertyStreet = domainModel.propertyStreet,
            value = domainModel.value,
            date = domainModel.date.toString()
        )
    }

    fun mapFromEntityList(entities: List<ExpenseCacheEntity>): List<Expense> {
        return entities.map { mapFromEntity(it) }
    }
}