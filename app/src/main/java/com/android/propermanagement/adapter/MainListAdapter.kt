package com.android.propermanagement.adapter

import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class MainListAdapter : ListDelegationAdapter<List<DiffItem>>(
    paymentHeaderAdapterDelegate {  },
    paymentAdapterDelegate {  },
    expenseAdapterDelegate {  },
    propertyAdapterDelegate {  }
)
