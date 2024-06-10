package pl.dakil.momentum.data.dao

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import pl.dakil.momentum.data.model.CountUnit

@Dao
interface CountUnitDao : BaseDao<CountUnit> {
    @Query("SELECT * FROM count_units ORDER BY order_no ASC, id ASC")
    fun getCountUnits(): Flow<List<CountUnit>>

    @Query("SELECT * FROM count_units WHERE id = :id")
    fun getCountUnit(id: Int): Flow<CountUnit>
}