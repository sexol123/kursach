package maleev.com.myapplication.data.net

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class Client {
    companion object {
        private var instance : Api? = null

        fun Client() : Api {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            val httpClient = OkHttpClient.Builder()
            httpClient.addInterceptor(logging)

            val retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .baseUrl(Api.BASE_URL)
                    .client(httpClient.build())
                    .build()
            return retrofit.create(Api::class.java)
        }

        fun getInstance() : Api {
            if (instance == null) {
                instance = Client()
            }
            return instance as Api
        }
    }
}