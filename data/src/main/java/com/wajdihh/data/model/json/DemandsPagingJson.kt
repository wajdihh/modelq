package com.wajdihh.data.model.json

data class DemandsPagingJson(
        val collection: List<DemandJson>,
        val pagination: PaginationJson
)