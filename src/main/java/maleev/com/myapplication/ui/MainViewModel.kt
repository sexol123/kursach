package maleev.com.myapplication.ui

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.content.Context
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import maleev.com.myapplication.repositories.GUserRepositoryImpl

class MainViewModel: ViewModel() {
    protected var disposables = CompositeDisposable()
    var repository : GUserRepositoryImpl = GUserRepositoryImpl()
    var guserLiveData : MutableLiveData<List<UserModel>> = MutableLiveData()

    fun getUsers(context : Context) {
        disposables.add(repository.getGUSer(context)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    guserLiveData.postValue(it)
                }, {
                    it.printStackTrace()
                }))
    }
}