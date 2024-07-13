package com.satria.absensi.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import com.satria.absensi.model.ModelDatabase
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * Created by Satria Pambudi on 13-07-2024
 * Github : https://github.com/SatriaPambudi15/Remidi-Mobile-Pro_SATRIA-PAMBUDI_STE202202924.git
 */

@Dao
interface DatabaseDao {
    @Query("SELECT * FROM tbl_absensi")
    fun getAllHistory(): LiveData<List<ModelDatabase>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(vararg modelDatabases: ModelDatabase)

    @Query("DELETE FROM tbl_absensi WHERE uid= :uid")
    fun deleteHistoryById(uid: Int)

    @Query("DELETE FROM tbl_absensi")
    fun deleteAllHistory()
}