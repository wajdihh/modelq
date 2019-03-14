package com.wajdihh.data.source.local

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.wajdihh.data.model.entity.DemandEntity
import com.wajdihh.data.model.entity.TBL_DEMAND
import io.reactivex.Completable
import io.reactivex.Single

/**
 * Created by wajdihh on 3/11/19.
 * Local dao
 */
@Dao
interface DemandDao {

    @Query("SELECT * FROM $TBL_DEMAND")
    fun getDemands(): Single<List<DemandEntity>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveDemands(array: List<DemandEntity>)
}