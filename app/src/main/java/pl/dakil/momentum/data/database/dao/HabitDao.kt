package pl.dakil.momentum.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import pl.dakil.momentum.data.database.model.Habit

@Dao
interface HabitDao : BaseDao<Habit> {
    @Query("SELECT * FROM habits ORDER BY is_pinned DESC, order_no ASC, id ASC")
    fun getMultipleWithUserOrder(): Flow<List<Habit>>

    @Query("SELECT * FROM habits WHERE id = :id")
    fun getOne(id: Int): Flow<Habit>
}