package com.octo.octobus.infrastructure.repository

import com.octo.octobus.domain.reservation.Coupon
import com.octo.octobus.domain.reservation.CouponRepository


class InMemoryCouponRepository(private var coupons: MutableList<Coupon>) : CouponRepository {

    override fun get(): List<Coupon> {
        return coupons
    }

    override fun save(coupons: List<Coupon>) {
        this.coupons.addAll(coupons)
    }
}