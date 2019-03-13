package com.wajdihh.data.model.json

import com.google.gson.annotations.SerializedName

data class QuestionJson(
        val answer: AnswerJson,
        @SerializedName("answer_title") val answerTitle: String,
        val caption: String,
        val choices: List<ChoiceJson>,
        val heading: String,
        val mandatory: Boolean,
        val max: Int,
        val type: String
)