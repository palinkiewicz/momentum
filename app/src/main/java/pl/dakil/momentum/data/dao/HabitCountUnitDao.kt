package pl.dakil.momentum.data.dao

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import pl.dakil.momentum.data.model.HabitCountUnit

@Dao
interface HabitCountUnitDao : BaseDao<HabitCountUnit> {
    @Query("SELECT * FROM habit_count_units ORDER BY order_no ASC, id ASC")
    fun getHabitCountUnits(): Flow<List<HabitCountUnit>>

    @Query("SELECT * FROM habit_count_units WHERE id = :id")
    fun getHabitCountUnit(id: Int): Flow<HabitCountUnit>
}