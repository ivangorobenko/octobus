package com.octo.octobus.infrastructure.repository

import com.octo.octobus.domain.reservation.Coupon


class InMemoryCouponRepository(private var coupons: MutableList<Coupon>) : Repository<List<Coupon>> {

    override fun get(): List<Coupon> {
        return coupons
    }

    override fun save(coupons: List<Coupon>) {
        this.coupons.addAll(coupons)
    }
}