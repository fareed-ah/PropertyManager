package com.android.propermanagement.adapter

import android.widget.ImageView
import android.widget.TextView
import com.android.propermanagement.R
import com.android.propermanagement.model.Payment
import com.android.propermanagement.model.PaymentHeader
import com.google.android.material.chip.Chip
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegate
import java.text.NumberFormat
import java.util.*

var fmt: NumberFormat = NumberFormat.getCurrencyInstance(Locale.CANADA)

fun paymentHeaderAdapterDelegate(itemClickedListener: (PaymentHeader) -> Unit) =
    adapterDelegate<PaymentHeader, DiffItem>(
        R.layout.item_payment_header
    ) {

        // This is the initializer block where you initialize the ViewHolder.
        // Its called one time only in onCreateViewHolder.
        // this is where you can call findViewById() and setup click listeners etc.

        val overdueAmount: TextView = findViewById(R.id.paymentOverdueSummary)
        val unpaidAmount: TextView = findViewById(R.id.paymentUnpaidSummary)
        // name.setClickListener { itemClickedListener(item) } // Item is automatically set for you. It's set lazily though (set in onBindViewHolder()). So only use it for deferred calls like clickListeners.

        bind { diffPayloads -> // diffPayloads is a List<Any> containing the Payload from your DiffUtils
            // This is called anytime onBindViewHolder() is called
            overdueAmount.text =
                fmt.format(item.overdueAmount) // Item is of type Cat and is the current bound item.
            unpaidAmount.text =
                fmt.format(item.unpaidAmount) // Item is of type Cat and is the current bound item.
        }
    }

fun paymentAdapterDelegate(itemClickedListener: (Payment) -> Unit) =
    adapterDelegate<Payment, DiffItem>(
        R.layout.item_payment
    ) {

        // This is the initializer block where you initialize the ViewHolder.
        // Its called one time only in onCreateViewHolder.
        // this is where you can call findViewById() and setup click listeners etc.

        val paymentValue: TextView = findViewById(R.id.paymentValue)
        val paymentDescription: TextView = findViewById(R.id.paymentDescription)
        val paymentDueDate: TextView = findViewById(R.id.paymentDate)
        val paymentOverdue: TextView = findViewById(R.id.paymentDaysOverdue)
        val paymentStatusChip: Chip = findViewById(R.id.paymentStatusChip)
        val payeeProfileAvatar: ImageView = findViewById(R.id.paymentAvatar)

        // name.setClickListener { itemClickedListener(item) } // Item is automatically set for you. It's set lazily though (set in onBindViewHolder()). So only use it for deferred calls like clickListeners.

        bind { diffPayloads -> // diffPayloads is a List<Any> containing the Payload from your DiffUtils
            // This is called anytime onBindViewHolder() is called
            paymentValue.text = fmt.format(item.value)
            paymentDescription.text = "${item.description} (${item.propertyStreet})"
            paymentDueDate.text = item.date.toString()
            paymentOverdue.text = "${item.days_overdue}  Days"
        }
    }