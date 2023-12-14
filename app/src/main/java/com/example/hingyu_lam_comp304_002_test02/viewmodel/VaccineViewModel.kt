package com.example.hingyu_lam_comp304_002_test02.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.hingyu_lam_comp304_002_test02.database.vaccine.VaccineDao

class VaccineViewModel(private val vaccineDao: VaccineDao): ViewModel() {

    fun fullPharmacies() = vaccineDao.getAllPharmacies()
    fun vaccineSchedulesOf(pharmacyId: Int) = vaccineDao.getVaccineSchedule(pharmacyId)

}

// Factory
class VaccineViewModelFactory(private val vaccineDao: VaccineDao): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(VaccineViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return VaccineViewModel(vaccineDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}