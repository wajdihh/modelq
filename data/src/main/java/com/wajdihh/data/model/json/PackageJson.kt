package com.wajdihh.data.model.json

data class PackageJson(
        val id: String,
        val name: String,
        val presentation: PresentationJson,
        val slug: String,
        val status: String
)