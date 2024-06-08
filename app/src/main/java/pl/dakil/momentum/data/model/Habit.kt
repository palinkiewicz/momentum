package pl.dakil.momentum.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.Date

@Entity(
    tableName = "Habits",
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
data class Habit (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "habit_count_unit_id") val habitCountUnitId: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "target") val target: Int,
    @ColumnInfo(name = "is_target_min") val isTargetMin: Boolean,
    @ColumnInfo(name = "graphical_resource") val graphicalResource: Int,
    @ColumnInfo(name = "created_at") val createdAt: Date,
    @ColumnInfo(name = "updated_at") val updatedAt: Date
)