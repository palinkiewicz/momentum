package pl.dakil.momentum.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "count_unit_display_names",
    indices = [
        Index("id", unique = true)
    ],
    foreignKeys = [
        ForeignKey(
            CountUnit::class,
            parentColumns = ["id"],
            childColumns = ["count_unit_id"],
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class CountUnitDisplayName (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "count_unit_id") val habitCountUnitId: Int,
    @ColumnInfo(name = "min_count") val minCount: Int,
    @ColumnInfo(name = "name") val name: Int
)