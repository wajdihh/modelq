package com.wajdihh.presentation.mock

import com.wajdihh.domain.model.Demand
import com.wajdihh.domain.model.DemandsPaging
import com.wajdihh.domain.model.Pager
import com.wajdihh.domain.model.User
import com.wajdihh.presentation.model.DemandItemUi
import com.wajdihh.presentation.model.DemandUi
import com.wajdihh.presentation.model.UserUi
import com.wajdihh.presentation.utils.Utility

class DataTest {
    val demand = Demand(id = 22,
            title = "my title",
            description = "my desc",
            price = 0.0,
            lat = 0.0,
            lng = 0.0,
            address = "my add",
            updateAt = "2017-10-05T11:43:16+02:00",
            user = User("Wajdi", "Hh", 0, "20-02-2018", "", ""),
            answerWizard = null)


    val demandItemUi = DemandItemUi(id = 22,
            title = "my title",
            address = "my add",
            price = 0.0,
            userName = "Wajdi Hh",
            distance = Utility.getCalculateDistance(0.0, 0.0, 0.0, 0.0),
            sinceAsDay = Utility.getSinceToDay("2017-10-05T11:43:16+02:00"),
            sinceAsMonth = Utility.getSinceToMonth("2017-10-05T11:43:16+02:00"),
            sinceAsWeek = Utility.getSinceToWeek("2017-10-05T11:43:16+02:00"))


    val demandUi = DemandUi(title = "my title",
            description = "my desc",
            address = "my add",
            price = 0.0,
            lat = 0.0,
            lng = 0.0,
            user = UserUi("Wajdi Hh", 0, "", ""))


    val demands = listOf(demand, demand, demand, demand)
    val demandPaging = DemandsPaging(pager = Pager(0, 0, 0), demands = demands)
}