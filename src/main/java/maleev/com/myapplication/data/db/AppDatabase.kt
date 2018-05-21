package maleev.com.myapplication.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = [UserEntity::class], version = 3)
abstract class AppDatabase : RoomDatabase() {

    abstract fun guserDao() : UserDao

    companion object {
        var INSTANCE : AppDatabase? = null
        fun getInstance(context : Context) : AppDatabase? {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE = Room
                            .databaseBuilder(context.applicationContext,
                                    AppDatabase::class.java, "gusers.db")
                            .build()
                }
            }
            return INSTANCE
        }
    }
}