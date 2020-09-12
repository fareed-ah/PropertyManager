package com.android.propermanagement.adapter

import android.widget.ImageView
import android.widget.TextView
import com.android.propermanagement.R
import com.android.propermanagement.model.Expense
import com.android.propermanagement.model.Payment
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegate
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation
import java.text.NumberFormat
import java.util.*

var currencyFormat: NumberFormat = NumberFormat.getCurrencyInstance(Locale.CANADA)

fun expenseAdapterDelegate(itemClickedListener: (Payment) -> Unit) =
    adapterDelegate<Expense, DiffItem>(
        R.layout.item_expense
    ) {

        // This is the initializer block where you initialize the ViewHolder.
        // Its called one time only in onCreateViewHolder.
        // this is where you can call findViewById() and setup click listeners etc.

        val expenseImage: ImageView = findViewById(R.id.expenseIcon)
        val expenseName: TextView = findViewById(R.id.expenseName)
        val expenseValue: TextView = findViewById(R.id.expenseAmount)
        val expensePropertyName: TextView = findViewById(R.id.expensePropertyName)
        val expenseDate: TextView = findViewById(R.id.expenseDate)

        // name.setClickListener { itemClickedListener(item) } // Item is automatically set for you. It's set lazily though (set in onBindViewHolder()). So only use it for deferred calls like clickListeners.

        bind { diffPayloads -> // diffPayloads is a List<Any> containing the Payload from your DiffUtils
            // This is called anytime onBindViewHolder() is called
            expenseName.text = item.name
            expenseValue.text = currencyFormat.format(item.value)
            expensePropertyName.text = item.propertyStreet
            expenseDate.text = item.date.toString()

            Picasso.get().load("https://i.imgur.com/DvpvklR.png").transform(
                RoundedCornersTransformation(250,0)
            ).into(expenseImage)

        }
    }