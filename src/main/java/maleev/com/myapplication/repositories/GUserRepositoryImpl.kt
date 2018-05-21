package maleev.com.myapplication.repositories

import android.content.Context
import io.reactivex.Single
import maleev.com.myapplication.data.db.AppDatabase
import maleev.com.myapplication.data.db.UserEntity
import maleev.com.myapplication.data.net.Client
import maleev.com.myapplication.data.net.UserResponse
import maleev.com.myapplication.ui.UserModel

class GUserRepositoryImpl:GUserRepository {
    override fun getGUSer(context: Context): Single<List<UserModel>> {
        return Client.Client().getCurrency()

                .map {
                    AppDatabase.getInstance(context)
                            ?.guserDao()
                            ?.insert(mapResponseToEntity(it))
                }.map {
                    mapEntityToModel(AppDatabase.getInstance(context)
                            ?.guserDao()
                            ?.getAll())
                }
    }
    private fun mapResponseToEntity(response : List<UserResponse>) : List<UserEntity> {
        return response.map {
            UserEntity(/*0,*/
                    it.id,
                    it.Login,
                    it.avatar_url
            )
        }
    }

    private fun mapEntityToModel(entity : List<UserEntity>?) : List<UserModel> {
        val list : ArrayList<UserModel> = ArrayList()
        entity?.map {
            val model : UserModel = UserModel()
            model.id = it.id
            model.Login = it.Login
            model.avatar_url = it.avatar_url
            list.add(model)
        }
        return list
    }

}