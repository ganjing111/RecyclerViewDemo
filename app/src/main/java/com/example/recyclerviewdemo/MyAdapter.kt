package com.example.recyclerviewdemo

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


/*
* Author:Ganjing
* Time:2024/6/23 18:19
*/
class MyAdapter(val context: Context):RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    var TYPE_APPLE_1 =1
    var TYPE_PEAR_2 =2

    var listData:MutableList<FruitEntity> = mutableListOf()

    open inner class ViewHolderAPPLE(view: View) : RecyclerView.ViewHolder(view){
        var tvId: TextView = view.findViewById(R.id.tv_id)
        var tvName: TextView = view.findViewById(R.id.tv_name)
        var img:ImageView = view.findViewById(R.id.img)
    }

    open inner class ViewHolderPEAR(view: View) : RecyclerView.ViewHolder(view){
        var tvId: TextView = view.findViewById(R.id.tv_id)
        var tvName: TextView = view.findViewById(R.id.tv_name)
    }

    override fun getItemCount():Int{
        Log.d("MyAdapter","1 getItemCount()")
        return listData.size
    }

    override fun getItemViewType(position: Int): Int {
        Log.d("MyAdapter","2 onCreateViewHolder()")
        if(listData.get(position).type==TYPE_PEAR_2){
            return TYPE_PEAR_2
        }
        return TYPE_APPLE_1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        Log.d("MyAdapter","3 onCreateViewHolder()")
        if(viewType==TYPE_APPLE_1){
            val view = LayoutInflater.from(context).inflate(R.layout.item_fruit,parent,false)
            val viewHolder = ViewHolderAPPLE(view)
            return viewHolder
        }else{
            val view = LayoutInflater.from(context).inflate(R.layout.item_pear,parent,false)
            val viewHolder = ViewHolderPEAR(view)
            return viewHolder
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.d("MyAdapter", "4 onBindViewHolder()")
        if (!listData.isEmpty() && listData.size != 0) {
            when(holder){
                is ViewHolderAPPLE->{
                    var fruit: FruitEntity = listData.get(position)
                    // int 类型转换为 String，不然报错
                    (holder as ViewHolderAPPLE).tvId.setText(fruit.id.toString())
                    (holder as ViewHolderAPPLE).tvName.setText(fruit.name)
                    // 图片我写死了
                    (holder as ViewHolderAPPLE).img.setImageResource(R.drawable.nav_icon)
                }
                is ViewHolderPEAR->{
                    var fruit: FruitEntity = listData.get(position)
                    // int 类型转换为 String，不然报错
                    (holder as ViewHolderPEAR).tvId.setText(fruit.id.toString())
                    (holder as ViewHolderPEAR).tvName.setText(fruit.name)
                }

            }
            /*if (holder is ViewHolderAPPLE) {
                var fruit: FruitEntity = listData.get(position)
                // int 类型转换为 String，不然报错
                (holder as ViewHolderAPPLE).tvId.setText(fruit.id.toString())
                (holder as ViewHolderAPPLE).tvName.setText(fruit.name)
                // 图片我写死了
                (holder as ViewHolderAPPLE).img.setImageResource(R.drawable.nav_icon)
            }else if(holder is ViewHolderPEAR){
                var fruit: FruitEntity = listData.get(position)
                // int 类型转换为 String，不然报错
                (holder as ViewHolderPEAR).tvId.setText(fruit.id.toString())
                (holder as ViewHolderPEAR).tvName.setText(fruit.name)
            }*/
        }
    }



    fun setUpdateData(listData1:MutableList<FruitEntity>){
        this.listData=listData1
        notifyDataSetChanged()
    }
}