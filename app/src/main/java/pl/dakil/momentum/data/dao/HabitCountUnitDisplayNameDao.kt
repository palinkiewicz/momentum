package pl.dakil.momentum.data.dao

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import pl.dakil.momentum.data.model.HabitCountUnitDisplayName

@Dao
interface HabitCountUnitDisplayNameDao : BaseDao<HabitCountUnitDisplayName> {
    @Query("SELECT * FROM habit_count_unit_display_names ORDER BY id")
    fun getHabitCountUnitDisplayNames(): Flow<List<HabitCountUnitDisplayName>>

    @Query("SELECT * FROM habit_count_unit_display_names WHERE id = :id")
    fun getHabitCountUnitDisplayName(id: Int): Flow<HabitCountUnitDisplayName>
}