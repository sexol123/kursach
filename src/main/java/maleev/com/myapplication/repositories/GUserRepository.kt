package maleev.com.myapplication.repositories

import android.content.Context
import io.reactivex.Single
import maleev.com.myapplication.ui.UserModel

interface GUserRepository {
    fun getGUSer(context: Context):Single<List<UserModel>>
}