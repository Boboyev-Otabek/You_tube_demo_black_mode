package com.example.you_tube.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.you_tube.R
import com.example.you_tube.model.Video
import com.google.android.material.imageview.ShapeableImageView

class VideoAdapter(var context: Context, var item: ArrayList<Video>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {



    override fun getItemCount(): Int {
        return item.size
    }





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {



        var view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.video_view, parent, false)
        return VideoViewHolder(view)


    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var video: Video = item[position]




        if (holder is VideoViewHolder) {

            var iv_video = holder.iv_video
            var iv_profile = holder.iv_profile
            var tv_fullname = holder.tv_fullname
            var tv_views = holder.tv_views

            iv_video.setImageResource(video.fon)
            iv_profile.setImageResource(video.profile)
            tv_fullname.text = video.fullname
            tv_views.text = video.views
        }
    }


    class VideoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var iv_video: ImageView
        var iv_profile: ShapeableImageView
        var tv_fullname: TextView
        var tv_views: TextView

        init {
            iv_video = view.findViewById(R.id.iv_video)
            iv_profile = view.findViewById(R.id.iv_video_profile)
            tv_fullname = view.findViewById(R.id.tv_video_fullname)
            tv_views = view.findViewById(R.id.tv_video_views)
        }
    }


}