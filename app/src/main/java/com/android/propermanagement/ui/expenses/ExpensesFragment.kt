package com.android.propermanagement.ui.expenses

import android.icu.util.Calendar
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import com.android.propermanagement.R
import com.android.propermanagement.adapter.MainListAdapter
import com.android.propermanagement.model.Expense
import com.android.propermanagement.util.DataState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_expenses.*

@AndroidEntryPoint
class ExpensesFragment : Fragment() {

    private val expenseListViewModel: ExpensesListViewModel by viewModels()

    private val adapter: MainListAdapter = MainListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_expenses, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        expensesRecyclerView.addItemDecoration( DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
        expensesRecyclerView.adapter = adapter

        expenseListViewModel.dataState.observe(viewLifecycleOwner, Observer { dataState ->
            when (dataState) {
                is DataState.Success<List<Expense>> -> {
                    displayProgressBar(false)
                    handlePropertiesReceived(dataState.data)
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
        expenseListViewModel.setStateEvent(ExpenseListStateEvent.GetExpenses)
    }

    private fun displayError(message: String?) {

    }

    private fun handlePropertiesReceived(expenses: List<Expense>) {
        var expensesList = mutableListOf(
            Expense(
                id = 1,
                name = "Gas",
                value = 52.0,
                propertyStreet = "101 Main Street",
                date = Calendar.getInstance().time

            ), Expense(
                id = 2,
                name = "Mortgage",
                value = 1502.0,
                propertyStreet = "434 Kenwood Ave",
                date = Calendar.getInstance().time
            ), Expense(
                id = 3,
                name = "Electricity",
                value = 220.0,
                propertyStreet = "56 Somerset",
                date = Calendar.getInstance().time
            ), Expense(
                id = 4,
                name = "Repair",
                value = 300.0,
                propertyStreet = "98 Cooper Street",
                date = Calendar.getInstance().time
            )
        )


        adapter.items = expensesList
        adapter.notifyDataSetChanged()
    }

    private fun displayProgressBar(enabled: Boolean) {

    }

}