package pl.dakil.momentum.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import pl.dakil.momentum.data.database.model.RecordedHabit
import java.util.Date

@Dao
interface RecordedHabitDao : BaseDao<RecordedHabit> {
    @Query("SELECT * FROM recorded_habits WHERE habit_id = :habitId ORDER BY date ASC")
    fun getMultipleFromHabitId(habitId: Int): Flow<List<RecordedHabit>>

    @Query("SELECT * FROM recorded_habits WHERE habit_id = :habitId AND date = :date")
    fun getOneFromHabitIdAndDate(habitId: Int, date: Date): Flow<RecordedHabit>
}