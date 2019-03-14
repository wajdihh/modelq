package com.wajdihh.data.model.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by wajdihh on 3/12/19.
 * Entity to save locally for the LIST
 */
@Entity(tableName = TBL_DEMAND)
class DemandEntity(
        @PrimaryKey(autoGenerate = true)
        var id: Long,
        var title: String,
        var address: String,
        var firstName: String,
        var lastName: String,
        var price: Double,
        var lat: Double,
        var lng: Double,
        var createdAt: String

)

const val TBL_DEMAND = "tbl_demand"
