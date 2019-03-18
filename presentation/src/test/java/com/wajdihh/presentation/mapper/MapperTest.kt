package com.wajdihh.presentation.mapper

import com.wajdihh.presentation.mock.DataTest
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class MapperTest {

    private lateinit var data: DataTest

    @Before
    fun setUp() {
        data = DataTest()
    }

    @Test
    fun `map demand to demandItemUi`() {
        //given
        val demand = data.demand
        val expected = data.demandItemUi
        //when
        val mapped = demand.toDemandItemUi(0.0, 0.0)
        //then
        assertEquals(expected, mapped)
    }

    @Test
    fun `map demand to demandUi`() {
        //given
        val demand = data.demand
        val expected = data.demandUi
        //when
        val mapped = demand.toDemandUi()
        //then
        assertEquals(expected, mapped)
    }
}