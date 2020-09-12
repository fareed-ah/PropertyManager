package com.android.propermanagement.model

import com.android.propermanagement.adapter.DiffItem
import java.util.*

data class Payment(
    var id: Int,
    var description: String,
    var value: Double,
    var date: Date,
    var days_overdue: Int,
    var propertyStreet: String
) : DiffItem