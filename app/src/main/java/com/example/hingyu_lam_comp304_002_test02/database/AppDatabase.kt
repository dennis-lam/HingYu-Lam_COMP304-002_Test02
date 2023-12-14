package com.example.hingyu_lam_comp304_002_test02.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.hingyu_lam_comp304_002_test02.database.vaccine.Pharmacy
import com.example.hingyu_lam_comp304_002_test02.database.vaccine.VaccineDao
import com.example.hingyu_lam_comp304_002_test02.database.vaccine.Schedule

// Class to manage database information
@Database(entities = [Pharmacy::class, Schedule::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun vaccineDao(): VaccineDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        // Get database singleton
        fun getDatabase(context: Context) = INSTANCE ?: synchronized(this) {
            INSTANCE = Room
                    .databaseBuilder(context, AppDatabase::class.java, "app database")
                    .createFromAsset("database/app.db")
                    .build()
            INSTANCE!!
        }
    }
}