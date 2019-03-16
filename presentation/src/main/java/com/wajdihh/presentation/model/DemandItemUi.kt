package com.wajdihh.presentation.model

data class DemandItemUi(val title: String,
                        val address: String,
                        val userName: String,
                        val price: Double,
                        val distance: Float,
                        val sinceAsDay: Long,
                        val sinceAsWeek: Long,
                        val sinceAsMonth: Long)