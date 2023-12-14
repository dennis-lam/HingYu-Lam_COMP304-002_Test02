package com.example.hingyu_lam_comp304_002_test02

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.hingyu_lam_comp304_002_test02.database.vaccine.VaccineSchedule
import com.example.hingyu_lam_comp304_002_test02.databinding.VaccineDetailsItemBinding

class VaccineDetailsAdapter(): ListAdapter<VaccineSchedule, VaccineDetailsAdapter.DetailViewHolder>(DiffCallback) {

    // Create a new holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DetailViewHolder(
        VaccineDetailsItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    // Bind a given view holder
    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    // Determine item different
    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<VaccineSchedule>() {
            override fun areItemsTheSame(oldItem: VaccineSchedule, newItem: VaccineSchedule): Boolean {
                return oldItem.pharmacyName == newItem.pharmacyName
                        && oldItem.date == newItem.date
                        && oldItem.time == newItem.time
            }
            override fun areContentsTheSame(oldItem: VaccineSchedule, newItem: VaccineSchedule) = oldItem == newItem
        }
    }

    class DetailViewHolder(private var binding: VaccineDetailsItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(schedule: VaccineSchedule) {
            with (binding) {
                pharmacyNameTextView.text = schedule.pharmacyName
                dateTextView.text = schedule.date
                timeTextView.text = schedule.time
            }
        }
    }
}