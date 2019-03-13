package com.wajdihh.domain.model

/**
 * Created by wajdihh on 3/11/19.
 * Used by domain layer
 */
data class Demand(val title: String,
                  val address: String,
                  val description: String,
                  val price: Double,
                  val lat: Double,
                  val lng: Double,
                  val user: User,
                  val answerWizard: AnswerWizard?)