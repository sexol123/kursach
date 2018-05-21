package maleev.com.myapplication.data.net

import io.reactivex.Single
import retrofit2.http.GET

interface Api {
    companion object {
        const val BASE_URL = "https://api.github.com"
    }

    @GET("/users")
    fun getCurrency() : Single<List<UserResponse>>
}