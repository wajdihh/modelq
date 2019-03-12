package com.wajdihh.data.model.json

import com.wajdihh.data.model.json.generated.DemandJson

data class DemandsPagingJson(
        val collection: List<DemandJson>,
        val pagination: PaginationJson
)