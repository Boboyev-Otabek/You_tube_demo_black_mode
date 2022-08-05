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
import com.example.you_tube.model.ShortVideo
import com.example.you_tube.model.Video
import com.google.android.material.imageview.ShapeableImageView

class VideoAdapter(var context: Context, var item: ArrayList<Video>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    var type_shortvideo = 0
    var type_video = 1

    override fun getItemCount(): Int {
        return item.size
    }

    override fun getItemViewType(position: Int): Int {

        return if (item[position].shortvideo.size>0) type_shortvideo else type_video
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if (viewType == type_shortvideo) {
            var view: View =
                LayoutInflater.from(parent.context).inflate(R.layout.item_short, parent, false)
            return ShortViewHolder(view)
        }


        var view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.video_view, parent, false)
        return VideoViewHolder(view)


    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var video: Video = item[position]

        if (holder is ShortViewHolder) {
            var rv_short: RecyclerView = holder.rv_short
            rv_short.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

            var short: ArrayList<ShortVideo> = video.shortvideo as ArrayList<ShortVideo>
            refreshAdapter(rv_short, short)

        }

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

    fun refreshAdapter(rv_short: RecyclerView, short: List<ShortVideo>) {
        var adapter = ShortVideoAdapter(context, short as ArrayList<ShortVideo>)
        rv_short.adapter = adapter
    }

    class ShortViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var rv_short: RecyclerView

        init {
            rv_short = view.findViewById(R.id.rv_shorts)
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