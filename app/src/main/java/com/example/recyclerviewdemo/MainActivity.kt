package com.example.recyclerviewdemo

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private var btnRefresh: Button?=null
    private var btnRefresh2: Button?=null
    private var recyerviewList:RecyclerView?=null
    private var listData:MutableList<FruitEntity>?= null
    private var adapter:MyAdapter ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // 初始化控件
        init()
        // 点击事件
        click()
    }

    fun init(){
        // 控件初始化
        btnRefresh = findViewById(R.id.btn_refresh)
        btnRefresh2 = findViewById(R.id.btn_refresh2)
        recyerviewList = findViewById(R.id.recyerview_list)

        // 集合初始化
        listData = mutableListOf()

        // adapter初始化
        adapter = MyAdapter(this@MainActivity)
        // 设置垂直方向
        var linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recyerviewList?.layoutManager=linearLayoutManager

        // 设置adapter
        recyerviewList?.adapter=adapter
    }

    fun click(){
        // 刷新按钮点击事件
        btnRefresh?.setOnClickListener{
            // 获取一些数据
            var newData = setData()
            // 把新的数据传给adapter，setUpdateData()是我自己写的
            adapter?.setUpdateData(newData!!)
            // 调用系统的刷新方法
            //adapter?.notifyDataSetChanged()
        }
        btnRefresh2?.setOnClickListener{
            // 获取一些数据
            var newData2 = setData2()
            // 把新的数据传给adapter，setUpdateData()是我自己写的
            adapter?.setUpdateData(newData2!!)
            // 调用系统的刷新方法
            adapter?.notifyDataSetChanged()
        }
    }


    private fun setData():MutableList<FruitEntity>? {
        listData?.clear()

        var i = 0;
        // 循环20次
        /*repeat(20){
            listData?.add(FruitEntity(++i,"Apple"))
        }*/
        listData?.add(FruitEntity(1,"Apple",1))
        listData?.add(FruitEntity(2,"Apple",1))
        listData?.add(FruitEntity(3,"pear",2))
        listData?.add(FruitEntity(4,"Apple",1))
        listData?.add(FruitEntity(5,"Apple",1))
        listData?.add(FruitEntity(6,"pear",2))
        listData?.add(FruitEntity(7,"Apple",1))


        return listData
    }

    private fun setData2():MutableList<FruitEntity>? {
        listData?.clear()

        var i = 0;
        // 循环20次
        repeat(20){
            listData?.add(FruitEntity(++i,"刷新数据2了",2))
        }

        return listData
    }
}