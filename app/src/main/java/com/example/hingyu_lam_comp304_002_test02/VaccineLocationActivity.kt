package com.example.hingyu_lam_comp304_002_test02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.coroutineScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hingyu_lam_comp304_002_test02.viewmodel.VaccineViewModel
import com.example.hingyu_lam_comp304_002_test02.viewmodel.VaccineViewModelFactory
import kotlinx.coroutines.launch

const val EXTRA_PHARMACY_ID = "com.example.hingyu_lam_comp304_002_test02.PHARMACY_ID"

class VaccineLocationActivity : AppCompatActivity() {

    private val viewModel: VaccineViewModel by viewModels {
        VaccineViewModelFactory(
            (application as VaccineScheduleApplication).database.vaccineDao()
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vaccine_location)

        // Get views
        val recyclerView = findViewById<RecyclerView>(R.id.location_recycler_view)

        // Set layout
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Set adapter
        val adapter = VaccineLocationAdapter {
            val intent = Intent(this, VaccineDetailsActivity::class.java)
            intent.putExtra(EXTRA_PHARMACY_ID, it.id)
            startActivity(intent)
        }
        recyclerView.adapter = adapter

        // Get full schedule
        lifecycle.coroutineScope.launch {
            viewModel.fullPharmacies().collect {
                adapter.submitList(it)
            }
        }
    }
}