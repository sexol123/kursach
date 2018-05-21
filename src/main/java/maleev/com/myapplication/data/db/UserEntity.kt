package maleev.com.myapplication.data.db

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "gusers")
data class UserEntity (
        //@PrimaryKey(autoGenerate = true)
        var id : Long = 0,

        @ColumnInfo(name = "login")
        @PrimaryKey()
        var Login : String = "",

        @ColumnInfo(name = "repos_url")
        var repo_url : String = "",

        @ColumnInfo(name = "avatar_url")
        var avatar_url : String = ""
)