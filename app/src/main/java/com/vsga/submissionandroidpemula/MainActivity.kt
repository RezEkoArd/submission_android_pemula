package com.vsga.submissionandroidpemula

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    private lateinit var rvRecipes: RecyclerView
    private lateinit var datalist: ArrayList<Menu>
    private lateinit var imageList: Array<Int>
    private lateinit var titleList: Array<String>
    private lateinit var durationList: Array<String>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //change to default light mode
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        imageList = arrayOf(
            R.drawable.spaghetti,
            R.drawable.ramen,
            R.drawable.cake,
            R.drawable.pancakes,
            R.drawable.pizza,
            R.drawable.burger,
            R.drawable.fries,
        )

        titleList = arrayOf(
            "pasta",
            "ramen",
            "cake",
            "pancakes",
            "pizza",
            "burger",
            "fries",
        )

        durationList = arrayOf(
            "30 Minutes",
            "2 Minutes",
            "45 Minutes",
            "10 Minutes",
            "60 Minutes",
            "45 Minutes",
            "30 Minutes",

        )

        rvRecipes = findViewById(R.id.rv_recipes)
        rvRecipes.layoutManager = LinearLayoutManager(this)
        rvRecipes.setHasFixedSize(true)


        //panggil data dari string ke recycleView
        datalist = arrayListOf()
        getData()

        rvRecipes.adapter = ListMenuAdapter(datalist)
    }


    private fun getData(){

        for (i in imageList.indices){
            val menuList = Menu(imageList[i], titleList[i], durationList[i])
            datalist.add(menuList)
        }

        rvRecipes.adapter = ListMenuAdapter(datalist)
    }

//    private fun getListMenu(): ArrayList<Menu> {
//        val dataName = resources.getStringArray(R.array.menu_name)
//        val dataDuration = resources.getStringArray(R.array.menu_duration)
//        val dataPhoto  = resources.obtainTypedArray(R.array.photo)
//        val listMenu = ArrayList<Menu>()
//        for (i in dataName.indices) {
//            val menu = Menu(dataName[i], dataDuration[i],dataPhoto.getResourceId(i, -1))
//            listMenu.add(menu)
//        }
//        return listMenu
//    }

//    private fun showRecyclerList(){
//        rvRecipes.layoutManager = LinearLayoutManager(this)
//        val listMenuAdapter = ListMenuAdapter(list)
//        rvRecipes.adapter = listMenuAdapter
//
//        listMenuAdapter.setOnItemClickCallback(object : ListMenuAdapter.OnItemClickCallback {
//            override fun onItemClicked(data: Menu) {
//                showSelectedMenu(data)
//            }
//        })
//    }
}