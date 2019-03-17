package com.wajdihh.domain.mock

import com.wajdihh.domain.model.Demand
import com.wajdihh.domain.model.DemandsPaging
import com.wajdihh.domain.model.Pager
import com.wajdihh.domain.model.User
import java.util.concurrent.ThreadLocalRandom

class DataTest {
    val demand = Demand(id = randomInt(),
            title = random(),
            description = random(),
            price = 0.0,
            lat = 0.0,
            lng = 0.0,
            address = random(),
            updateAt = random(),
            user = User(random(), random(), 0, random(), random(), random()),
            answerWizard = null)

    val demands = listOf(demand, demand, demand, demand)
    val demandPaging = DemandsPaging(pager = Pager(0, 0, 0), demands = demands)


    private fun random(): String {
        return java.util.UUID.randomUUID().toString()
    }

    private fun randomInt(): Int {
        return ThreadLocalRandom.current().nextInt(0, 1000 + 1)
    }
}