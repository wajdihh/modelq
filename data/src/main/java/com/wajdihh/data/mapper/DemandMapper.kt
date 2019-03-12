package com.wajdihh.data.mapper

import com.wajdihh.data.model.json.DemandsPagingJson
import com.wajdihh.data.model.json.PaginationJson
import com.wajdihh.data.model.json.generated.AnswerWizardJson
import com.wajdihh.data.model.json.generated.DemandJson
import com.wajdihh.domain.model.AnswerWizard
import com.wajdihh.domain.model.Demand
import com.wajdihh.domain.model.DemandsPaging
import com.wajdihh.domain.model.Pager

/**
 * Created by wajdihh on 3/12/19.
 * Mapper data to domain
 */
fun DemandsPagingJson.toDemandsPaging() = DemandsPaging(pager = pagination.toPager(),
        demands = collection.map { it.toDemand() })


fun PaginationJson.toPager() = Pager(currentPage = currentPage,
        perPage = perPage,
        total = total)

fun DemandJson.toDemand() = Demand(title = title,
        address = address,
        description = description,
        price = unit_price.toDouble(),
        lat = lat.toDouble(),
        lng = lng.toDouble(),
        user = user.toUser(),
        answerWizard = null
)

fun AnswerWizardJson.toAnswerWizard() = AnswerWizard(id = id, wizard = wizard)