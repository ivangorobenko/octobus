package com.octo.octobus.domain.reservation

interface CouponRepository {
    fun get(): List<Coupon>
    fun save(coupons: List<Coupon>)
}