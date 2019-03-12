package com.wajdihh.data.model.json.generated

/**
 * NB  : j'ai generé cette classe avec le plugin (Generate Kotlin data classes from JSON) Just pour Gagner le temps
 */
data class Question(
        val answer: Answer,
        val answer_title: String,
        val caption: String,
        val caption_action: String,
        val choices: List<Choice>,
        val heading: String,
        val mandatory: Boolean,
        val max: Int,
        val question_title: String,
        val type: String
)