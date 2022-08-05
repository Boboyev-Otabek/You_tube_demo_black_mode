package com.example.you_tube

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.you_tube.adapter.FilterAdapter
import com.example.you_tube.adapter.VideoAdapter
import com.example.you_tube.model.Filter
import com.example.you_tube.model.ShortVideo
import com.example.you_tube.model.Video


class MainActivity : AppCompatActivity() {

    lateinit var rv_filter: RecyclerView
    lateinit var rv_feed: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    fun initViews() {
        rv_filter = findViewById(R.id.rv_filter)
        rv_filter.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        refreshFilter(getAllFilter())

        rv_feed = findViewById(R.id.rv_feed)
        rv_feed.layoutManager = GridLayoutManager(this, 1)

        refreshFeed(getAllFeed())


    }

    fun refreshFeed(video:ArrayList<Video>){
        var adater=VideoAdapter(this,video)
        rv_feed.adapter=adater
    }

    fun getAllFeed():ArrayList<Video>{
        var video=ArrayList<Video>()


        video.add(Video(R.drawable.video_1,R.drawable.user_2,"Video 1","1 mln marta",ArrayList<ShortVideo>()))
        video.add(Video(R.drawable.video_2,R.drawable.user_1,"Video 2","1 mln marta",ArrayList<ShortVideo>()))
        video.add(Video(R.drawable.video_3,R.drawable.user_3,"Video 3","1 mln marta",ArrayList<ShortVideo>()))
        video.add(Video(R.drawable.video_4,R.drawable.user_4,"Video 4","1 mln marta",ArrayList<ShortVideo>()))
        video.add(Video(R.drawable.video_1,R.drawable.user_1,"Video 5","1 mln marta",ArrayList<ShortVideo>()))
        video.add(Video(R.drawable.video_2,R.drawable.user_2,"Video 6","1 mln marta",ArrayList<ShortVideo>()))


        video.add(Video(R.drawable.video_1,R.drawable.user_2,"Video 1","1 mln marta",getAllShort()))

        video.add(Video(R.drawable.video_1,R.drawable.user_2,"Video 1","1 mln marta",ArrayList<ShortVideo>()))
        video.add(Video(R.drawable.video_2,R.drawable.user_1,"Video 2","1 mln marta",ArrayList<ShortVideo>()))
        video.add(Video(R.drawable.video_3,R.drawable.user_3,"Video 3","1 mln marta",ArrayList<ShortVideo>()))
        video.add(Video(R.drawable.video_4,R.drawable.user_4,"Video 4","1 mln marta",ArrayList<ShortVideo>()))
        video.add(Video(R.drawable.video_1,R.drawable.user_1,"Video 5","1 mln marta",ArrayList<ShortVideo>()))
        video.add(Video(R.drawable.video_2,R.drawable.user_2,"Video 6","1 mln marta",ArrayList<ShortVideo>()))


        video.add(Video(R.drawable.video_1,R.drawable.user_2,"Video 1","1 mln marta",getAllShort()))



        return video
    }


    fun getAllShort():ArrayList<ShortVideo>{
        var shortvideo=ArrayList<ShortVideo>()

        shortvideo.add(ShortVideo(R.drawable.short_1,"Short 1","2 mln marta"))
        shortvideo.add(ShortVideo(R.drawable.short_2,"Short 2","4 mln marta"))
        shortvideo.add(ShortVideo(R.drawable.short_3,"Short 3","0.5 mln marta"))
        shortvideo.add(ShortVideo(R.drawable.short_4,"Short 4","1 mln marta"))


        return shortvideo
    }



    fun refreshFilter(filters: ArrayList<Filter>) {
        var adapter = FilterAdapter(this, filters)
        rv_filter.adapter = adapter
    }

    fun getAllFilter(): ArrayList<Filter> {

        var filters = ArrayList<Filter>()

        filters.add(Filter("Java"))
        filters.add(Filter("C#"))
        filters.add(Filter("PHP"))
        filters.add(Filter("C++"))
        filters.add(Filter("C"))
        filters.add(Filter("Kotlin"))
        filters.add(Filter("Java"))
        filters.add(Filter("C#"))
        filters.add(Filter("PHP"))
        filters.add(Filter("C++"))
        filters.add(Filter("C"))
        filters.add(Filter("Kotlin"))

        return filters
    }
}