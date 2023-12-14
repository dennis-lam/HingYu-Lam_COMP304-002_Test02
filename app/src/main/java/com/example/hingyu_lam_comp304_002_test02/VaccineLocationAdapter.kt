package com.example.hingyu_lam_comp304_002_test02

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.hingyu_lam_comp304_002_test02.database.vaccine.Pharmacy
import com.example.hingyu_lam_comp304_002_test02.databinding.VaccineLocationItemBinding

class VaccineLocationAdapter(private val onItemClicked: (Pharmacy) -> Unit): ListAdapter<Pharmacy, VaccineLocationAdapter.VaccineLocationViewHolder>(DiffCallback) {

    // Create a new holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VaccineLocationViewHolder {
        val viewHolder = VaccineLocationViewHolder(
            VaccineLocationItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
        viewHolder.itemView.setOnClickListener {
            val position = viewHolder.adapterPosition
            onItemClicked(getItem(position))
        }
        return viewHolder
    }

    // Bind a given view holder
    override fun onBindViewHolder(holder: VaccineLocationViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    // Determine item different
    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Pharmacy>() {
            override fun areItemsTheSame(oldItem: Pharmacy, newItem: Pharmacy): Boolean = oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: Pharmacy, newItem: Pharmacy): Boolean = oldItem == newItem
        }
    }

    class VaccineLocationViewHolder(private var binding: VaccineLocationItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(pharmacy: Pharmacy) {
            with (binding) {
                pharmacyNameTextView.text = pharmacy.name
                pharmacyLocationTextView.text = pharmacy.location
            }
        }
    }
}