package com.wajdihh.data.mapper

import com.wajdihh.data.model.entity.DemandEntity
import com.wajdihh.data.model.json.*
import com.wajdihh.domain.model.*

/**
 * Created by wajdihh on 3/12/19.
 * Mapper data to domain
 */
fun DemandsPagingJson.toDemandsPaging() = DemandsPaging(pager = pagination.toPager(),
        demands = collection.map { it.toDemand() })


fun PaginationJson.toPager() = Pager(currentPage = currentPage,
        perPage = perPage,
        total = total)

fun DemandJson.toDemand() = Demand(
        id = id,
        title = title ?: "",
        address = address ?: "",
        description = description ?: "",
        price = (unitPrice ?: "0").toDouble(),
        lat = (lat ?: "0").toDouble(),
        lng = (lng ?: "0").toDouble(),
        updateAt = updatedAt,
        user = user?.toUser(),
        answerWizard = answerWizard?.toAnswerWizard()
)

fun WizardJson.toWizard() = Wizard(id = id)

fun AnswerWizardJson.toAnswerWizard() = AnswerWizard(id = id, wizard = wizard?.toWizard())

/// Local entity mapper
/**
 * For this example of caching I choose one page  with 50 items, just to get something when launching the app in offline mode (Like Facebook)
 */
fun List<DemandEntity>.toDemandsPaging() = DemandsPaging(pager = Pager(1, 50, size), demands = this.map { it.toDemand() })

fun DemandEntity.toDemand() = Demand(
        id = id,
        title = title,
        address = address,
        description = "",
        price = price,
        lat = lat,
        lng = lng,
        updateAt = updateAt,
        user = User(firstName, lastName, firstName, 0, "", "", ""),
        answerWizard = null
)

fun Demand.toDemandEntity() = DemandEntity(
        id = id,
        title = title,
        address = address,
        firstName = user?.firstName ?: "",
        lastName = user?.lastName ?: "",
        price = price,
        lat = lat,
        lng = lng,
        updateAt = updateAt)