package com.satria.absensi.database

import androidx.room.Database
import com.satria.absensi.model.ModelDatabase
import androidx.room.RoomDatabase
import com.satria.absensi.database.dao.DatabaseDao

/**
 * Created by Satria Pambudi on 13-07-2024
 * Github : https://github.com/SatriaPambudi15/Remidi-Mobile-Pro_SATRIA-PAMBUDI_STE202202924.git
 */

@Database(entities = [ModelDatabase::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun databaseDao(): DatabaseDao?
}