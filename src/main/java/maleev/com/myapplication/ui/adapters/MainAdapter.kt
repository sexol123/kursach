package maleev.com.myapplication.ui.adapters

import android.app.Application
import android.app.Fragment
import android.content.Context
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import maleev.com.myapplication.R
import maleev.com.myapplication.ui.MainActivity
import maleev.com.myapplication.ui.UserModel
import java.util.*

class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    var data : List<UserModel> = Collections.emptyList()

    class ViewHolder(item : View) : RecyclerView.ViewHolder(item) {

        val textUid : TextView = item.findViewById(R.id.text_userid)
        val textLogin : TextView = item.findViewById(R.id.text_userlogin)
        val photoAvatar: ImageView = item.findViewById(R.id.image_avatar)

    }

    fun setDate(list : List<UserModel>?) {
        this.data = list!!
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int) : ViewHolder {
        val view : View = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.itemguser, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount() : Int {
        return data.size
    }

    override fun onBindViewHolder(holder : ViewHolder, position : Int) {
        holder.textUid.text = data[position].id.toString()
        holder.textLogin.text = data[position].Login
        //holder.photoAvatar.setImageURI(Uri.parse(data[position].avatar_url))
//        if(data[position].avatar_url.isNotEmpty()){
//            Picasso.with(holder.photoAvatar.context).load(data[position].avatar_url).into(holder.photoAvatar)
//        }

    }


}