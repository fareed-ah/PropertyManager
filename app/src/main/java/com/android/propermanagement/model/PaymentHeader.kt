package com.android.propermanagement.model

import com.android.propermanagement.adapter.DiffItem

data class PaymentHeader(
    var overdueAmount: Double,
    var unpaidAmount: Double
) : DiffItem