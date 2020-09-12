package com.android.propermanagement.ui.properties

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
import com.android.propermanagement.adapter.PropertyListAdapter
import com.android.propermanagement.model.Property
import com.android.propermanagement.ui.MainActivity
import com.android.propermanagement.util.DataState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_property_list.*

@AndroidEntryPoint
class PropertyListFragment : Fragment() {

    private val propertyListViewModel: PropertyListViewModel by viewModels()

    private val adapter = MainListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_property_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addPropertyFab.setOnClickListener {
            (requireActivity() as MainActivity).replaceFragment(
                AddPropertyFragment()
            )
        }

        propertiesRecyclerView.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )

        propertiesRecyclerView.adapter = adapter

        propertyListViewModel.dataState.observe(viewLifecycleOwner, Observer { dataState ->
            when (dataState) {
                is DataState.Success<List<Property>> -> {
                    displayProgressBar(false)
                    if (dataState.data.isEmpty()) {
                        propertiesRecyclerView.visibility = View.GONE
                        propertyListMessageText.visibility = View.VISIBLE
                        propertyListMessageText.text = "Add a new property to manage!"
                    } else {
                        propertiesRecyclerView.visibility = View.VISIBLE
                        propertyListMessageText.visibility = View.GONE
                        handlePropertiesReceived(dataState.data)
                    }

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
        propertyListViewModel.setStateEvent(PropertyListStateEvent.GetProperties)
    }

    private fun handlePropertiesReceived(properties: List<Property>) {

        adapter.items = properties
        adapter.notifyDataSetChanged()
    }

    private fun displayError(message: String?) {

    }

    private fun displayProgressBar(loading: Boolean) {

    }

}