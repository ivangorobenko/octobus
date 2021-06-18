package com.octo.octobus.infrastructure.repository

import com.octo.octobus.domain.reservation.Bus

class InMemoryBusRepository(private var bus: Bus = Bus(10)) : Repository<Bus> {

    override fun get(): Bus {
        return bus
    }

    override fun save(bus: Bus) {
        this.bus = bus
    }
}