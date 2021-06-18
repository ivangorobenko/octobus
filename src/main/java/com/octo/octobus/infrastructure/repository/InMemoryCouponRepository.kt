package com.octo.octobus.infrastructure.repository

import com.octo.octobus.domain.reservation.Coupon


class InMemoryCouponRepository(private var coupons: MutableList<Coupon> = ArrayList()) : Repository<List<Coupon>> {

    override fun get(): List<Coupon> {
        return coupons
    }

    override fun save(value: List<Coupon>) {
        this.coupons.addAll(value)
    }
}