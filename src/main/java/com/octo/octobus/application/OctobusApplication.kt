package com.octo.octobus.application

import MakeAReservationHandler
import com.octo.octobus.domain.core.command.HandlerFactory
import com.octo.octobus.infrastructure.repository.InMemoryBusRepository
import com.octo.octobus.infrastructure.repository.InMemoryCouponRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = arrayOf("application","domain"))
 class OctobusApplication(@Autowired var handlerFactory: HandlerFactory) {
    init {
        val couponRepository = InMemoryCouponRepository()
        val busRepository = InMemoryBusRepository()

        this.handlerFactory.setMakeAReservationHandler(MakeAReservationHandler(couponRepository, busRepository))
    }
}

fun main(args: Array<String>) {
    runApplication<OctobusApplication>(*args)
}