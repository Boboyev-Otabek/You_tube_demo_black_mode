package com.example.you_tube.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.you_tube.R
import com.example.you_tube.model.Filter
import java.text.FieldPosition

class FilterAdapter(var context: Context, var item: ArrayList<Filter>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    var item_type_explore = 0
    var item_type_all = 1
    var item_type_filter=2

    fun isExplore(position: Int): Boolean {
        return position == 0
    }
    fun isAll(position: Int):Boolean{
        return position==1
    }

    override fun getItemCount(): Int {
        return item.size
    }


    override fun getItemViewType(position: Int): Int {
        if(isExplore(position)) return item_type_explore
        if(isAll(position)) return item_type_all
        return item_type_filter
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType==item_type_explore){
            var view=LayoutInflater.from(parent.context).inflate(R.layout.item_explore_view,parent,false)
            return ExploreViewHolder(view)
        }
        else if(viewType==item_type_all){
            var view=LayoutInflater.from(parent.context).inflate(R.layout.item_all_view,parent,false)
            return AllViewHolder(view)
        }


            var view=LayoutInflater.from(parent.context).inflate(R.layout.item_filter_view,parent,false)
            return FilterViewHolder(view)

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var filter=item[position]

        if(holder is FilterViewHolder){
            var tv_title=holder.tv_title
            tv_title.text=filter.title
        }
    }


    class ExploreViewHolder(view: View):RecyclerView.ViewHolder(view){}

    class AllViewHolder(view: View):RecyclerView.ViewHolder(view){}


    class FilterViewHolder(view: View):RecyclerView.ViewHolder(view){
        var tv_title:TextView
        init {
            tv_title=view.findViewById(R.id.tv_filter)
        }
    }


}