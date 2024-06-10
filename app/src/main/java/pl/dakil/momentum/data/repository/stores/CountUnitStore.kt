package pl.dakil.momentum.data.repository.stores

import kotlinx.coroutines.flow.Flow
import pl.dakil.momentum.data.database.dao.CountUnitDao
import pl.dakil.momentum.data.database.dao.CountUnitDisplayNameDao
import pl.dakil.momentum.data.database.model.CountUnit
import pl.dakil.momentum.data.database.model.CountUnitDisplayName

interface CountUnitStore {
    suspend fun createCountUnit(unit: CountUnit)

    suspend fun updateCountUnit(unit: CountUnit)

    suspend fun deleteCountUnit(unit: CountUnit)

    fun getCountUnits(): Flow<List<CountUnit>>

    fun getCountUnit(id: Int): Flow<CountUnit>

    suspend fun createCountUnitDisplayName(displayName: CountUnitDisplayName)

    suspend fun updateCountUnitDisplayName(displayName: CountUnitDisplayName)

    suspend fun deleteCountUnitDisplayName(displayName: CountUnitDisplayName)

    fun getCountUnitDisplayNames(id: Int): Flow<List<CountUnitDisplayName>>

    fun getCountUnitDisplayNamesFromCount(id: Int, count: Int): Flow<CountUnitDisplayName>
}

class LocalCountUnitStore(
    private val countUnitDao: CountUnitDao,
    private val countUnitDisplayNameDao: CountUnitDisplayNameDao
) : CountUnitStore {
    override suspend fun createCountUnit(unit: CountUnit) {
        countUnitDao.insert(unit)
    }

    override suspend fun updateCountUnit(unit: CountUnit) {
        countUnitDao.update(unit)
    }

    override suspend fun deleteCountUnit(unit: CountUnit) {
        countUnitDao.delete(unit)
    }

    override fun getCountUnits(): Flow<List<CountUnit>> {
        return countUnitDao.getMultiple()
    }

    override fun getCountUnit(id: Int): Flow<CountUnit> {
        return countUnitDao.getOne(id)
    }

    override suspend fun createCountUnitDisplayName(displayName: CountUnitDisplayName) {
        countUnitDisplayNameDao.insert(displayName)
    }

    override suspend fun updateCountUnitDisplayName(displayName: CountUnitDisplayName) {
        countUnitDisplayNameDao.update(displayName)
    }

    override suspend fun deleteCountUnitDisplayName(displayName: CountUnitDisplayName) {
        countUnitDisplayNameDao.delete(displayName)
    }

    override fun getCountUnitDisplayNames(id: Int): Flow<List<CountUnitDisplayName>> {
        return countUnitDisplayNameDao.getMultipleFromUnitId(id)
    }

    override fun getCountUnitDisplayNamesFromCount(id: Int, count: Int): Flow<CountUnitDisplayName> {
        return countUnitDisplayNameDao.getOneFromUnitIdAndCount(id, count)
    }
}