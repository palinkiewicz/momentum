package pl.dakil.momentum.data.repository.stores

import kotlinx.coroutines.flow.Flow
import pl.dakil.momentum.data.dao.HabitDao
import pl.dakil.momentum.data.dao.RecordedHabitDao
import pl.dakil.momentum.data.model.Habit
import pl.dakil.momentum.data.model.RecordedHabit
import java.util.Date

interface HabitStore {
    suspend fun createHabit(habit: Habit)

    suspend fun updateHabit(habit: Habit)

    suspend fun deleteHabit(habit: Habit)

    fun getHabitsWithUserOrder(): Flow<List<Habit>>

    fun getHabit(id: Int): Flow<Habit>

    suspend fun createHabitRecord(record: RecordedHabit)

    suspend fun updateHabitRecord(record: RecordedHabit)

    suspend fun deleteHabitRecord(record: RecordedHabit)

    fun getHabitRecords(id: Int): Flow<List<RecordedHabit>>

    fun getHabitRecordFromDate(id: Int, date: Date): Flow<RecordedHabit>
}

class LocalHabitStore(
    private val habitDao: HabitDao,
    private val recordedHabitDao: RecordedHabitDao
) : HabitStore {
    override suspend fun createHabit(habit: Habit) {
        habitDao.insert(habit)
    }

    override suspend fun updateHabit(habit: Habit) {
        habitDao.update(habit)
    }

    override suspend fun deleteHabit(habit: Habit) {
        habitDao.delete(habit)
    }

    /**
     * Returns all of the habits in order specified by a user
     */
    override fun getHabitsWithUserOrder(): Flow<List<Habit>> {
        return habitDao.getMultipleWithUserOrder()
    }

    override fun getHabit(id: Int): Flow<Habit> {
        return habitDao.getOne(id)
    }

    override suspend fun createHabitRecord(record: RecordedHabit) {
        recordedHabitDao.insert(record)
    }

    override suspend fun updateHabitRecord(record: RecordedHabit) {
        recordedHabitDao.update(record)
    }

    override suspend fun deleteHabitRecord(record: RecordedHabit) {
        recordedHabitDao.delete(record)
    }

    /**
     * Returns all of the data recorded by user for a selected habit
     */
    override fun getHabitRecords(id: Int): Flow<List<RecordedHabit>> {
        return recordedHabitDao.getMultipleFromHabitId(id)
    }

    override fun getHabitRecordFromDate(id: Int, date: Date): Flow<RecordedHabit> {
        return recordedHabitDao.getOneFromHabitIdAndDate(id, date)
    }
}
