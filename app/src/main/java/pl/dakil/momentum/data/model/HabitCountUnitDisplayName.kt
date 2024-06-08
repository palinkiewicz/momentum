package pl.dakil.momentum.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "habit_count_unit_display_names",
    indices = [
        Index("id", unique = true)
    ],
    foreignKeys = [
        ForeignKey(
            HabitCountUnit::class,
            parentColumns = ["id"],
            childColumns = ["habit_count_unit_id"],
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class HabitCountUnitDisplayName (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "habit_count_unit_id") val habitCountUnitId: Int,
    @ColumnInfo(name = "min_count") val minCount: Int,
    @ColumnInfo(name = "name") val name: Int
)