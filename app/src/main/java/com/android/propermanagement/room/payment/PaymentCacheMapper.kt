package com.android.propermanagement.room.payment

import com.android.propermanagement.model.Payment
import com.android.propermanagement.util.EntityMapper
import java.sql.Date
import javax.inject.Inject

class PaymentCacheMapper
@Inject constructor() : EntityMapper<PaymentCacheEntity, Payment> {
    override fun mapFromEntity(entity: PaymentCacheEntity): Payment {
        return Payment(
            id = entity.id,
            description = entity.description,
            value = entity.value,
            date = Date.valueOf(entity.date),
            days_overdue = entity.days_overdue,
            propertyStreet = entity.propertyStreet
        )
    }

    override fun mapToEntity(domainModel: Payment): PaymentCacheEntity {
        return PaymentCacheEntity(
            id = domainModel.id,
            description = domainModel.description,
            value = domainModel.value,
            date = domainModel.date.toString(),
            days_overdue = domainModel.days_overdue,
            propertyStreet = domainModel.propertyStreet
        )
    }

    fun mapFromEntityList(entities: List<PaymentCacheEntity>): List<Payment> {
        return entities.map { mapFromEntity(it) }
    }
}