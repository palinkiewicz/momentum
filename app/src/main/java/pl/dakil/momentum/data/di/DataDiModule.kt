package pl.dakil.momentum.data.di

import android.content.Context
import pl.dakil.momentum.data.database.MomentumDatabase
import pl.dakil.momentum.data.repository.MomentumRepository
import pl.dakil.momentum.data.repository.stores.CountUnitStore
import pl.dakil.momentum.data.repository.stores.HabitStore
import pl.dakil.momentum.data.repository.stores.LocalCountUnitStore
import pl.dakil.momentum.data.repository.stores.LocalHabitStore

interface DataDiModule {
    val momentumRepository: MomentumRepository

    val habitStore: HabitStore
        get() = momentumRepository.getHabitStore()
    val countUnitStore: CountUnitStore
        get() = momentumRepository.getCountUnitStore()
}

class LocalDataDiModule(private val context: Context) : DataDiModule {
    private val database: MomentumDatabase by lazy {
        MomentumDatabase.getDatabase(context)
    }

    override val momentumRepository: MomentumRepository = MomentumRepository(
        LocalHabitStore(database.habitDao(), database.recordedHabitDao()),
        LocalCountUnitStore(database.habitCountUnitDao(), database.habitCountUnitDisplayNameDao())
    )
}