package pl.dakil.momentum.data.dao

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import pl.dakil.momentum.data.model.RecordedHabit

@Dao
interface RecordedHabitDao : BaseDao<RecordedHabit> {
    @Query("SELECT * FROM recorded_habits WHERE habit_id = :habitId ORDER BY date ASC")
    fun getRecordedHabitsForHabitId(habitId: Int): Flow<List<RecordedHabit>>

    @Query("SELECT * FROM recorded_habits WHERE id = :id")
    fun getRecordedHabit(id: Int): Flow<RecordedHabit>
}