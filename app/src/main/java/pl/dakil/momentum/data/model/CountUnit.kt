package pl.dakil.momentum.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "count_units",
    indices = [
        Index("id", unique = true)
    ]
)
class CountUnit (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "is_timed") val isTimed: Boolean,
    @ColumnInfo(name = "timed_interval") val timedInterval: UShort,
    @ColumnInfo(name = "timed_value_change") val timedValueChange: Int,
    @ColumnInfo(name = "order_no") val orderNo: Short
)