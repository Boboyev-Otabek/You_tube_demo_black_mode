package com.example.you_tube.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.you_tube.R
import com.example.you_tube.model.ShortVideo

class ShortVideoAdapter(var context: Context, var short: List<ShortVideo>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount(): Int {
        return short.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view:View=LayoutInflater.from(parent.context).inflate(R.layout.shorts_view,parent,false)
        return ShortVideoViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        var shortvideo=short[position]

        if(holder is ShortVideoViewHolder){
            var iv_fon=holder.iv_fon
            var tv_fullname=holder.tv_fullname
            var tv_views=holder.tv_views

            iv_fon.setImageResource(shortvideo.fon)
            tv_fullname.text=shortvideo.fullname
            tv_views.text=shortvideo.views
        }
    }

    class ShortVideoViewHolder(view: View):RecyclerView.ViewHolder(view){

        var iv_fon:ImageView
        var tv_fullname:TextView
        var tv_views:TextView

        init {
            iv_fon=view.findViewById(R.id.iv_short_video)
            tv_fullname=view.findViewById(R.id.tv_short_title)
            tv_views=view.findViewById(R.id.tv_short_views)
        }
    }
}