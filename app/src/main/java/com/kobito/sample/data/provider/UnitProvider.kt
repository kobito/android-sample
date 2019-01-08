package com.kobito.sample.data.provider

import com.kobito.sample.internal.UnitSystem

interface UnitProvider {
    fun getUnitSystem(): UnitSystem
}