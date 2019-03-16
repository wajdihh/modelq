package com.wajdihh.presentation.mapper

import com.wajdihh.domain.model.Demand
import com.wajdihh.domain.model.DemandsPaging
import com.wajdihh.presentation.model.DemandItemUi
import com.wajdihh.presentation.model.DemandUi
import com.wajdihh.presentation.model.DemandsPagingUi
import com.wajdihh.presentation.utils.Utility


fun Demand.toDemandItemUi(myLat: Double, myLng: Double) = DemandItemUi(title = title,
        address = address,
        userName = (user?.firstName ?: "") + " " + (user?.lastName ?: ""),
        price = price,
        distance = Utility.getCalculateDistance(myLat, myLng, lat, lng),
        sinceAsDay = Utility.getSinceToDay(updateAt),
        sinceAsWeek = Utility.getSinceToWeek(updateAt),
        sinceAsMonth = Utility.getSinceToMonth(updateAt)
)

fun Demand.toDemandUi() = DemandUi(title = title,
        address = address,
        userName = user?.firstName ?: "",
        price = price,
        distance = lat,
        since = Utility.getSinceToDay(updateAt))


fun DemandsPaging.toDemandsPagingUi(myLat: Double, myLng: Double) = DemandsPagingUi(total = pager.total,
                                                        currentPage = pager.currentPage,
        demands = demands.map { it.toDemandItemUi(myLat, myLng) })
