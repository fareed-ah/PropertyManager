package com.android.propermanagement.model

import com.android.propermanagement.adapter.DiffItem

data class Property(
    var id: Int,
    var address: String,
    var bedrooms: Int,
    var bathrooms: Int,
    var imageUrl: String
) : DiffItem