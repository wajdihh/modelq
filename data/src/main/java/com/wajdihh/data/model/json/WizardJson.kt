package com.wajdihh.data.model.json

data class WizardJson(
        val configuration: ConfigurationJson,
        val id: String,
        val `package`: PackageJson,
        val questions: List<QuestionJson>
)