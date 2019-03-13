package com.wajdihh.data.factory

import android.arch.persistence.room.Room
import android.content.Context
import com.wajdihh.data.source.local.DemandDao
import com.wajdihh.data.source.local.MyDatabase

/**
 * Created by wajdihh on 3/12/19.
 * To create Dao
 */

object DataLocalFactory {

    /**
     * Create DAOs
     */
    fun createDaoDemand(context: Context): DemandDao = createMyDataBase(context).demandDao()

    /**
     * Create the database
     */
    private fun createMyDataBase(context: Context): MyDatabase {
        return Room.databaseBuilder(context, MyDatabase::class.java, "ModelQProjectDB")
                .fallbackToDestructiveMigration()
                .build()
    }
}