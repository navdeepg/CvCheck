package com.cvcheck.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.cvcheck.R
import com.cvcheck.databinding.ItemExperienceBinding
import com.cvcheck.databinding.ItemSkillBinding
import com.cvcheck.db.entity.ExperienceType
import com.cvcheck.db.entity.SkillType

class ExperienceAdapter(private var experienceList: List<ExperienceType>?) : RecyclerView.Adapter<ExperienceAdapter
.PayoutsViewHolder>
    () {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PayoutsViewHolder {
        val binding = DataBindingUtil.inflate<ItemExperienceBinding>(
                LayoutInflater.from(parent.context), R.layout.item_experience, parent, false)

        return PayoutsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PayoutsViewHolder, position: Int) {
        holder.binding.experience = experienceList!![position]
    }

    override fun getItemCount(): Int {
        return if (experienceList == null) 0 else experienceList!!.size
    }

    class PayoutsViewHolder(val binding: ItemExperienceBinding) : RecyclerView.ViewHolder(binding.root)
}
