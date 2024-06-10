package pl.dakil.momentum.data.dao

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import pl.dakil.momentum.data.model.CountUnitDisplayName

@Dao
interface CountUnitDisplayNameDao : BaseDao<CountUnitDisplayName> {
    @Query("SELECT * FROM count_unit_display_names WHERE count_unit_id = :unitId ORDER BY id")
    fun getMultipleFromUnitId(unitId: Int): Flow<List<CountUnitDisplayName>>

    @Query(
        """
        SELECT * FROM count_unit_display_names
        WHERE count_unit_id = :unitId AND min_count <= :count
        ORDER BY min_count DESC
        LIMIT 1
        """
    )
    fun getOneFromUnitIdAndCount(unitId: Int, count: Int): Flow<CountUnitDisplayName>
}