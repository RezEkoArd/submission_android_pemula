package com.vsga.submissionandroidpemula

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    private lateinit var rvRecipes: RecyclerView
    private val list = ArrayList<Menu>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //change to default light mode
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        rvRecipes = findViewById(R.id.rv_recipes)
        rvRecipes.setHasFixedSize(true)


        //panggil data dari string ke recycleView
        list.addAll(getListMenu())
        showRecyclerList()
    }

    private fun getListMenu(): ArrayList<Menu> {
        val dataName = resources.getStringArray(R.array.menu_name)
        val dataDuration = resources.getStringArray(R.array.menu_duration)
        val dataPhoto  = resources.obtainTypedArray(R.array.photo)
//        dataPhoto.recycle()
        val listMenu = ArrayList<Menu>()
        for (i in dataName.indices) {
            val menu = Menu(dataName[i], dataDuration[i],dataPhoto.getResourceId(i, -1))
            listMenu.add(menu)
        }
        return listMenu
    }

    private fun showRecyclerList(){
        rvRecipes.layoutManager = LinearLayoutManager(this)
        val listMenuAdapter = ListMenuAdapter(list)
        rvRecipes.adapter = listMenuAdapter
    }
}