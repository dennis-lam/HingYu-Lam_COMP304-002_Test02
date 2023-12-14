package com.example.hingyu_lam_comp304_002_test02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.coroutineScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hingyu_lam_comp304_002_test02.viewmodel.VaccineViewModel
import com.example.hingyu_lam_comp304_002_test02.viewmodel.VaccineViewModelFactory
import kotlinx.coroutines.launch

class VaccineDetailsActivity : AppCompatActivity() {

    private val viewModel: VaccineViewModel by viewModels {
        VaccineViewModelFactory(
            (application as VaccineScheduleApplication).database.vaccineDao()
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vaccine_details)

        // Get extra
        val pharmacyId = intent.getIntExtra(EXTRA_PHARMACY_ID, -1)
        if (pharmacyId == -1) throw IllegalArgumentException("Unable to find the pharmacy ID")

        // Get views
        val recyclerView = findViewById<RecyclerView>(R.id.details_recycler_view)

        // Set layout
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Set adapter
        val adapter = VaccineDetailsAdapter()
        recyclerView.adapter = adapter

        // Get full schedule
        lifecycle.coroutineScope.launch {
            viewModel.vaccineSchedulesOf(pharmacyId).collect {
                adapter.submitList(it)
            }
        }
    }
}