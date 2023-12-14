package com.example.hingyu_lam_comp304_002_test02.database.vaccine

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity
data class VaccineSchedule(
    @ColumnInfo val pharmacyName: String,
    @ColumnInfo val date: String,
    @ColumnInfo val time: String
)