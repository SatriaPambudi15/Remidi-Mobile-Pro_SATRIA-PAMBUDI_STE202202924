package com.satria.absensi.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.satria.absensi.database.DatabaseClient.Companion.getInstance
import com.satria.absensi.database.dao.DatabaseDao
import com.satria.absensi.model.ModelDatabase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.schedulers.Schedulers

/**
 * Created by Satria Pambudi on 19-11-2021
 * Github : https://github.com/SatriaPambudi15/Remidi-Mobile-Pro_SATRIA-PAMBUDI_STE202202924.git
 */

class AbsenViewModel(application: Application) : AndroidViewModel(application) {
    var databaseDao: DatabaseDao? = getInstance(application)?.appDatabase?.databaseDao()

    fun addDataAbsen(
        foto: String, nama: String,
        tanggal: String, lokasi: String, keterangan: String) {
        Completable.fromAction {
            val modelDatabase = ModelDatabase()
            modelDatabase.fotoSelfie = foto
            modelDatabase.nama = nama
            modelDatabase.tanggal = tanggal
            modelDatabase.lokasi = lokasi
            modelDatabase.keterangan = keterangan
            databaseDao?.insertData(modelDatabase)
        }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
    }

}