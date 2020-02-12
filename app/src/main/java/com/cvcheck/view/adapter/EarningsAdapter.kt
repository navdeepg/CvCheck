package com.cvcheck.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.cvcheck.R
import com.cvcheck.databinding.ItemExperienceBinding

class EarningsAdapter() : RecyclerView.Adapter<EarningsAdapter.PayoutsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PayoutsViewHolder {
        val binding = DataBindingUtil.inflate<ItemExperienceBinding>(
                LayoutInflater.from(parent.context), R.layout.item_experience, parent, false)

        return PayoutsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PayoutsViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return 0
    }

    class PayoutsViewHolder(val binding: ItemExperienceBinding) : RecyclerView.ViewHolder(binding.root)
}
