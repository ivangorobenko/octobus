package com.octo.octobus.infrastructure.repository

interface Repository<T> {
    fun get(): T
    fun save(value: T)
}