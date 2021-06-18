package com.octo.octobus.application.controller

import com.jayway.jsonpath.JsonPath
import com.octo.octobus.application.OctobusApplication
import com.octo.octobus.domain.reservation.query.CouponReadModel
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders


@SpringBootTest(classes = [OctobusApplication::class])
@AutoConfigureMockMvc
class ReservationControllerTest {

    @Autowired
    private val mvc: MockMvc? = null

    @Test
    fun makeAReservation() {
        //WHEN
        mvc?.perform(MockMvcRequestBuilders.post("/reservations").accept(MediaType.APPLICATION_JSON))

        //THEN
        var result = mvc?.perform(MockMvcRequestBuilders.get("/coupons"))

        val coupons: List<CouponReadModel> =
            JsonPath.read(result?.andReturn()?.response?.contentAsString, "$")
        assertEquals(1, coupons.size)

    }

}

