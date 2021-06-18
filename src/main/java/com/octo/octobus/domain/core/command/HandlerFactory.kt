package com.octo.octobus.domain.core.command

import MakeAReservationHandler
import org.springframework.stereotype.Service

@Service
class HandlerFactory() {
    private lateinit var makeAReservationHandler: MakeAReservationHandler

    fun setMakeAReservationHandler(makeAReservationHandler: MakeAReservationHandler) {
        this.makeAReservationHandler = makeAReservationHandler
    }

    fun getMakeAReservationHandler(): MakeAReservationHandler {
        return this.makeAReservationHandler
    }
}