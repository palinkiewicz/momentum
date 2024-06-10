package pl.dakil.momentum.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import pl.dakil.momentum.data.database.dao.CountUnitDao
import pl.dakil.momentum.data.database.dao.CountUnitDisplayNameDao
import pl.dakil.momentum.data.database.dao.HabitDao
import pl.dakil.momentum.data.database.dao.RecordedHabitDao
import pl.dakil.momentum.data.database.model.Habit
import pl.dakil.momentum.data.database.model.CountUnit
import pl.dakil.momentum.data.database.model.CountUnitDisplayName
import pl.dakil.momentum.data.database.model.RecordedHabit

@Database(
    entities = [
        Habit::class,
        CountUnit::class,
        CountUnitDisplayName::class,
        RecordedHabit::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(DateConverters::class)
abstract class MomentumDatabase : RoomDatabase() {
    abstract fun habitDao(): HabitDao
    abstract fun habitCountUnitDao(): CountUnitDao
    abstract fun habitCountUnitDisplayNameDao(): CountUnitDisplayNameDao
    abstract fun recordedHabitDao(): RecordedHabitDao

    companion object {
        @Volatile
        private var Instance: MomentumDatabase? = null

        fun getDatabase(context: Context): MomentumDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, MomentumDatabase::class.java, "momentum_db")
                    .build().also { Instance = it }
            }
        }
    }
}