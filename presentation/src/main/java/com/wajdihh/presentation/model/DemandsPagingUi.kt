package com.wajdihh.presentation.model

data class DemandsPagingUi(val total: Int,
                           val currentPage: Int,
                           val demands: List<DemandItemUi>)