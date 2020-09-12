package com.android.propermanagement.model

import com.android.propermanagement.adapter.DiffItem
import java.util.*

data class Expense(
    var id: Int,
    var name: String,
    var propertyStreet: String,
    var value: Double,
    var date: Date
) : DiffItem