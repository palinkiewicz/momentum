package pl.dakil.momentum.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import pl.dakil.momentum.data.database.model.CountUnit

@Dao
interface CountUnitDao : BaseDao<CountUnit> {
    @Query("SELECT * FROM count_units ORDER BY order_no ASC, id ASC")
    fun getMultiple(): Flow<List<CountUnit>>

    @Query("SELECT * FROM count_units WHERE id = :id")
    fun getOne(id: Int): Flow<CountUnit>
}