package com.gabrielkou.domain.test.factory

import java.util.concurrent.ThreadLocalRandom

class DataFactory {

    companion object {
        fun randomInt(): Int {
            return ThreadLocalRandom.current().nextInt(0, 1000 + 1)
        }

        fun randomLong(): Long {
            return randomInt().toLong()
        }

        fun randomUuid(): String {
            return java.util.UUID.randomUUID().toString()
        }
    }
}