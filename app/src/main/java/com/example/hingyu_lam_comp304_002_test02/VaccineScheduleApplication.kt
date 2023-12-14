package com.example.hingyu_lam_comp304_002_test02

import android.app.Application
import com.example.hingyu_lam_comp304_002_test02.database.AppDatabase

class VaccineScheduleApplication: Application() {
    val database: AppDatabase by lazy { AppDatabase.getDatabase(this) }
}