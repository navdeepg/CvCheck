package com.cvcheck.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.cvcheck.R
import com.cvcheck.databinding.ItemExperienceBinding
import com.cvcheck.databinding.ItemSkillBinding
import com.cvcheck.db.entity.SkillType

class SkillsAdapter(private var skillList: List<SkillType>?) : RecyclerView.Adapter<SkillsAdapter.PayoutsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PayoutsViewHolder {
        val binding = DataBindingUtil.inflate<ItemSkillBinding>(
                LayoutInflater.from(parent.context), R.layout.item_skill, parent, false)

        return PayoutsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PayoutsViewHolder, position: Int) {
        holder.binding.skill = skillList!![position]
    }

    override fun getItemCount(): Int {
        return if (skillList == null) 0 else skillList!!.size
    }

    class PayoutsViewHolder(val binding: ItemSkillBinding) : RecyclerView.ViewHolder(binding.root)
}
