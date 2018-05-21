package maleev.com.myapplication.data.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(currency : List<UserEntity>)

    @Query("select * from gusers")
    fun getAll() : List<UserEntity>
}