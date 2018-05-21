package maleev.com.myapplication.data.net

import com.google.gson.annotations.SerializedName

data class UserResponse (

       @SerializedName("id")
        var id : Long = 0,

        @SerializedName("login")
        var Login : String = "",

        @SerializedName("repo_url")
        var repo_url : String = "",

        @SerializedName("avatar_url")
        var avatar_url : String = ""
)