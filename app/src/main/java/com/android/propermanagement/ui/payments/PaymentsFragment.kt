package com.android.propermanagement.ui.payments

import android.icu.util.Calendar
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import com.android.propermanagement.R
import com.android.propermanagement.adapter.MainListAdapter
import com.android.propermanagement.model.Payment
import com.android.propermanagement.model.PaymentHeader
import com.android.propermanagement.util.DataState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_payments.*

@AndroidEntryPoint
class PaymentsFragment : Fragment() {

    private val paymentListViewModel: PaymentListViewModel by viewModels()
    private val adapter = MainListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_payments, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        paymentRecyclerView.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )

        paymentRecyclerView.adapter = adapter

        paymentListViewModel.dataState.observe(viewLifecycleOwner, Observer { dataState ->
            when (dataState) {
                is DataState.Success<List<Payment>> -> {
                    displayProgressBar(false)
                    handlePaymentsReceived(dataState.data)
                }
                is DataState.Error -> {
                    displayProgressBar(false)
                    displayError(dataState.exception.message)
                }
                is DataState.Loading -> {
                    displayProgressBar(true)
                }
            }
        })
        paymentListViewModel.setStateEvent(PaymentListStateEvent.GetPayments)
    }

    private fun handlePaymentsReceived(payments: List<Payment>) {
        var paymentList = mutableListOf(
            PaymentHeader(2000.0, 2000.0),
            Payment(
                id = 1,
                description = "Monthly Rent",
                value = 2500.0,
                date = Calendar.getInstance().time,
                days_overdue = 0,
                propertyStreet = "101 Main Street"
            ), Payment(
                id = 1,
                description = "Rent",
                value = 3000.0,
                date = Calendar.getInstance().time,
                days_overdue = 0,
                propertyStreet = "101 Main Street"
            ), Payment(
                id = 1,
                description = "Deposit",
                value = 500.0,
                date = Calendar.getInstance().time,
                days_overdue = 0,
                propertyStreet = "101 Main Street"
            ), Payment(
                id = 1,
                description = "Monthly Rent",
                value = 1200.0,
                date = Calendar.getInstance().time,
                days_overdue = 0,
                propertyStreet = "101 Main Street"
            ), Payment(
                id = 1,
                description = "Monthly Rent",
                value = 1000.0,
                date = Calendar.getInstance().time,
                days_overdue = 0,
                propertyStreet = "101 Main Street"
            )
        )

        adapter.items = paymentList
//        paymentRecyclerView.adapter = PaymentListAdapter(paymentList)
        adapter.notifyDataSetChanged()
    }

    private fun displayError(message: String?) {

    }

    private fun displayProgressBar(loading: Boolean) {

    }

}