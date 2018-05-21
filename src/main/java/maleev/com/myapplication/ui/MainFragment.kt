package maleev.com.myapplication.ui

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import maleev.com.myapplication.R
import maleev.com.myapplication.databinding.FragmentMainBinding
import maleev.com.myapplication.ui.adapters.MainAdapter


class MainFragment: Fragment() {
    lateinit var binding : FragmentMainBinding
    lateinit var adapter : MainAdapter
    lateinit var viewModel : MainViewModel

    override fun onCreateView(inflater : LayoutInflater, container : ViewGroup?, savedInstanceState : Bundle?) : View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.getUsers(activity!!)

        binding.recycler.layoutManager = LinearLayoutManager(context)
        adapter = MainAdapter()
        binding.recycler.adapter = adapter

        viewModel.guserLiveData.observe(this, Observer<List<UserModel>> {
            adapter.setDate(it)
        })


        return binding.root
    }
}