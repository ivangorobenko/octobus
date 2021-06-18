package com.octo.octobus.domain.reservation

class Bus(private val totalNumberOfSeats: Int) {
    private var numberOfReservedSeats = 0
    fun reserve(numberOfSeatsToReserve: Int): List<Coupon> {
        if (numberOfSeatsToReserve + numberOfReservedSeats > totalNumberOfSeats) return listOf()

        val firstSeatToReserve = numberOfReservedSeats + 1
        val lastSeatToReserve = numberOfReservedSeats + numberOfSeatsToReserve
        val coupons = (firstSeatToReserve..lastSeatToReserve).map { Coupon(it) }
        numberOfReservedSeats += numberOfSeatsToReserve
        return coupons
    }

}

