package com.wajdihh.data.source.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.wajdihh.data.model.entity.DemandEntity

/**
 * Created by wajdihh on 3/13/19.
 * ROmm config
 */

@Database(entities = [(DemandEntity::class)], version = 1)

abstract class MyDatabase : RoomDatabase() {

    abstract fun demandDao(): DemandDao
}