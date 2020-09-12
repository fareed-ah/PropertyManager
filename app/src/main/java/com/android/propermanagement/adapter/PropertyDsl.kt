package com.android.propermanagement.adapter

import android.widget.ImageView
import com.android.propermanagement.R
import com.android.propermanagement.model.Property
import com.google.android.material.textview.MaterialTextView
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegate
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation


fun propertyAdapterDelegate(itemClickedListener: (Property) -> Unit) =
    adapterDelegate<Property, DiffItem>(
        R.layout.item_property
    ) {

        // This is the initializer block where you initialize the ViewHolder.
        // Its called one time only in onCreateViewHolder.
        // this is where you can call findViewById() and setup click listeners etc.

        val propertyImage: ImageView = findViewById(R.id.propertyImage)
        val propertyAddressText: MaterialTextView = findViewById(R.id.propertyAddressText)
        val propertyBedroomsText: MaterialTextView = findViewById(R.id.propertyBedroomsText)
        val propertyBathroomsText: MaterialTextView = findViewById(R.id.propertyBathroomsText)

        // name.setClickListener { itemClickedListener(item) } // Item is automatically set for you. It's set lazily though (set in onBindViewHolder()). So only use it for deferred calls like clickListeners.

        bind { diffPayloads -> // diffPayloads is a List<Any> containing the Payload from your DiffUtils
            // This is called anytime onBindViewHolder() is called
            propertyAddressText.text = item.address
            propertyBathroomsText.text = item.bathrooms.toString()
            propertyBedroomsText.text = item.bedrooms.toString()
            Picasso.get().load(item.imageUrl).transform(
                RoundedCornersTransformation(50, 0)
            ).into(propertyImage);

        }
    }