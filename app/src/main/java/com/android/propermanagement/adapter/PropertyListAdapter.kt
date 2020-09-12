package com.android.propermanagement.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.propermanagement.R
import com.android.propermanagement.model.Property
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation
import kotlinx.android.synthetic.main.item_property.view.*

class PropertyListAdapter(private val items: List<Property>) :
    RecyclerView.Adapter<PropertyListAdapter.PropertyViewHolder>() {

    class PropertyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PropertyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_property,parent,false)

        return PropertyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: PropertyViewHolder, position: Int) {
        val property = items[position]
        val propertyImage = holder.itemView.propertyImage
        val propertyAddressText = holder.itemView.propertyAddressText
        val propertyBedroomsText= holder.itemView.propertyBedroomsText
        val propertyBathroomsText= holder.itemView.propertyBathroomsText

        propertyAddressText.text = property.address
        propertyBathroomsText.text = property.bathrooms.toString()
        propertyBedroomsText.text = property.bedrooms.toString()

        Picasso.get().load("https://i.imgur.com/DvpvklR.png").transform(RoundedCornersTransformation(50,0)).into(propertyImage);

    }

}