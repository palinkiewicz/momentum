package pl.dakil.momentum.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey


@Entity(
    tableName = "habits_habit_count_units",
    indices = [
        Index("id", unique = true)
    ],
    foreignKeys = [
        ForeignKey(
            Habit::class,
            parentColumns = ["id"],
            childColumns = ["habit_id"],
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            HabitCountUnit::class,
            parentColumns = ["id"],
            childColumns = ["habit_count_unit_id"],
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class HabitToHabitCountUnitEntry (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "habit_id") val habitId: Int,
    @ColumnInfo(name = "habit_count_unit_id") val habitCountUnitId: Int,
)