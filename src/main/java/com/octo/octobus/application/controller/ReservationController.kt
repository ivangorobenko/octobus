package com.octo.octobus.application.controller

import MakeAReservation
import MakeAReservationHandler
import com.fasterxml.jackson.databind.ObjectMapper
import com.octo.octobus.domain.core.command.HandlerFactory
import com.octo.octobus.domain.reservation.Bus
import com.octo.octobus.domain.reservation.Coupon
import com.octo.octobus.domain.reservation.query.CouponReadModel
import com.octo.octobus.infrastructure.repository.InMemoryBusRepository
import com.octo.octobus.infrastructure.repository.Repository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class ReservationController {

    @Autowired
    lateinit var handlerFactory: HandlerFactory

    @PostMapping(path = ["/reservations"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun makeAReservation() {
        handlerFactory.getMakeAReservationHandler().handle(MakeAReservation(1))
    }

    @GetMapping(path = ["/coupons"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAReservation(): String {
        var coupons = listOf(CouponReadModel("1"))
        val objectMapper = ObjectMapper()
        return objectMapper.writeValueAsString(coupons)
    }


}