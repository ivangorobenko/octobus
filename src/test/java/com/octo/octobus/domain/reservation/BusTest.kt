package com.octo.octobus.domain.reservation

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName

internal class BusTest {

    @Test
    @DisplayName("Ne doit pas permettre de réserver de siège si le train est plein")
    fun shouldNotReserveAnySeatsWhenTheTrainIsFull() {
        //GIVEN
        val wagon = Bus(10)
        wagon.reserve(1)
        wagon.reserve(1)
        wagon.reserve(1)
        wagon.reserve(1)
        wagon.reserve(1)
        wagon.reserve(1)
        wagon.reserve(1)
        wagon.reserve(1)
        wagon.reserve(1)
        wagon.reserve(1)

        //WHEN
        val coupons = wagon.reserve(1)

        //THEN
        assertTrue(coupons.isEmpty())
    }

    @Test
    fun `ne doit pas permettre de réserver le nombre de siège supérieur à la capacité du wagon`() {
        //GIVEN
        val wagon = Bus(10)

        //WHEN
        val coupons = wagon.reserve(11)

        //THEN
        assertTrue(coupons.isEmpty())
    }


    @Test
    fun `doit réserver le prochain siège libre`() {
        //GIVEN
        val wagon = Bus(10)
        wagon.reserve(5)

        //WHEN
        val coupons = wagon.reserve(1)

        //THEN
        assertEquals(listOf(Coupon(6)), coupons);
    }

    @Test
    fun `doit permettre de réserver plusieurs sièges`() {
        //GIVEN
        val wagon = Bus(10)

        //WHEN
        val coupons = wagon.reserve(2)

        //THEN
        assertEquals(listOf(Coupon(1), Coupon(2)), coupons);
    }
}