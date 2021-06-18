package com.octo.octobus.domain.reservation

interface BusRepository {
    fun get(): Bus
    fun save(bus: Bus)
}