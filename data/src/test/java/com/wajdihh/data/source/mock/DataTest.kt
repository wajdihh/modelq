package com.wajdihh.data.source.mock

import com.wajdihh.data.model.entity.DemandEntity
import com.wajdihh.domain.request.SearchRequest
import java.util.concurrent.ThreadLocalRandom

class DataTest {
        val params = SearchRequest(lat = 48.8694023,
                lng = 2.3522692,
                radius = 50,
                type = "mission",
                page = 1,
                perPage = 20)

        val demandId = 2333

        val demandEntity = DemandEntity(randomInt(), random(), random(), random(), random(), 0.0, 0.0, 0.0, random())
        val demandEntities = listOf(demandEntity, demandEntity, demandEntity, demandEntity)


        private fun random(): String {
            return java.util.UUID.randomUUID().toString()
        }

        private fun randomInt(): Int {
            return ThreadLocalRandom.current().nextInt(0, 1000 + 1)
        }
}