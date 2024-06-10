package pl.dakil.momentum.data.repository

import pl.dakil.momentum.data.repository.stores.CountUnitStore
import pl.dakil.momentum.data.repository.stores.HabitStore

class MomentumRepository(
    private val habitStore: HabitStore,
    private val countUnitStore: CountUnitStore
) {
    fun getHabitStore(): HabitStore = habitStore

    fun getCountUnitStore(): CountUnitStore = countUnitStore
}