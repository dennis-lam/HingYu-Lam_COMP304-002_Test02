package com.example.hingyu_lam_comp304_002_test02.database.vaccine

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

// Data access object of the schedules
@Dao
interface VaccineDao {

    @Query("SELECT * FROM Pharmacy ORDER BY name")
    fun getAllPharmacies(): Flow<List<Pharmacy>>

    @Query("SELECT c.name as pharmacyName, s.date as date, s.time as time " +
            "FROM Pharmacy c, Schedule s " +
            "WHERE c.id = s.pharmacyId " +
            "AND c.id = :pharmacyId ")
    fun getVaccineSchedule(pharmacyId: Int) : Flow<List<VaccineSchedule>>

}