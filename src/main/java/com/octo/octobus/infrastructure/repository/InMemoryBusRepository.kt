package com.octo.octobus.infrastructure.repository

import com.octo.octobus.domain.reservation.Bus
import com.octo.octobus.domain.reservation.BusRepository

class InMemoryBusRepository(private var bus: Bus = Bus(10)) : BusRepository {

    override fun get(): Bus {
        return bus
    }

    override fun save(bus: Bus) {
        this.bus = bus
    }
}