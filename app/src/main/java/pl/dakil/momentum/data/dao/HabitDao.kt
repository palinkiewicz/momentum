package pl.dakil.momentum.data.dao

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import pl.dakil.momentum.data.model.Habit

@Dao
interface HabitDao : BaseDao<Habit> {
    @Query("SELECT * FROM habits ORDER BY is_pinned DESC, order_no ASC, id ASC")
    fun getHabitsWithUserOrder(): Flow<List<Habit>>

    @Query("SELECT * FROM habits WHERE id = :id")
    fun getHabit(id: Int): Flow<Habit>
}