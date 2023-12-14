package com.example.hingyu_lam_comp304_002_test02.database.vaccine

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Pharmacy(
    @PrimaryKey val id: Int,
    @NonNull @ColumnInfo val name: String,
    @NonNull @ColumnInfo val location: String,
)