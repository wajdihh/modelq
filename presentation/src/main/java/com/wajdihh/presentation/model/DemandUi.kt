package com.wajdihh.presentation.model

data class DemandUi(val title: String,
                    val description: String,
                    val address: String,
                    val price: Double,
                    val lat: Double,
                    val lng: Double,
                    val user: UserUi?)