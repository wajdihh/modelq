package com.wajdihh.presentation.mapper

import com.wajdihh.domain.model.Demand
import com.wajdihh.domain.model.DemandsPaging
import com.wajdihh.presentation.model.DemandUi
import com.wajdihh.presentation.model.DemandsPagingUi


fun Demand.toDemandUi() = DemandUi(title = title,
                                   address = address,
                                   userName = user.firstName,
                                   price = price,
                                   type = "",
                                   distance = lat,
                                   since = 1)


fun DemandsPaging.toDemandsPagingUi() = DemandsPagingUi(total = pager.total,
                                                        currentPage = pager.currentPage,
                                                        demands = demands.map { it.toDemandUi() })