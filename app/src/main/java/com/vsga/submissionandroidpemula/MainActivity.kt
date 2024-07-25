package com.vsga.submissionandroidpemula

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    private lateinit var rvRecipes: RecyclerView
    private lateinit var datalist: ArrayList<Menu>
    private lateinit var imageList: Array<Int>
    private lateinit var titleList: Array<String>
    private lateinit var durationList: Array<String>

//    Variable to detail Activity
    private lateinit var ingredientList:Array<String>
    private lateinit var stepsList:Array<String>
    private lateinit var myAdapter: ListMenuAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // SplashScreen Thread
        Thread.sleep(3000)
        installSplashScreen()

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

        ingredientList = arrayOf(
            getString(R.string.pastaIngredients),
            getString(R.string.maggiIngredients),
            getString(R.string.cakeIngredients),
            getString(R.string.pancakeIngredients),
            getString(R.string.pizzaIngredients),
            getString(R.string.burgerIngredients),
            getString(R.string.friesIngredients),
        )

        stepsList = arrayOf(
            getString(R.string.pastaDesc),
            getString(R.string.maggieDesc),
            getString(R.string.cakeDesc),
            getString(R.string.pancakeDesc),
            getString(R.string.pizzaDesc),
            getString(R.string.burgerDesc),
            getString(R.string.friesDesc),
        )

        rvRecipes = findViewById(R.id.rv_recipes)
        rvRecipes.layoutManager = LinearLayoutManager(this)
        rvRecipes.setHasFixedSize(true)


        //panggil data dari string ke recycleView
        datalist = arrayListOf()
        getData()

        // initialization and set adapter
        myAdapter = ListMenuAdapter(datalist)
        rvRecipes.adapter = myAdapter


        myAdapter.onItemClick = {
            val intent = Intent(this, RecipeActivity::class.java)
            intent.putExtra("android", it)
            startActivity(intent)
        }
    }


    private fun getData(){

        for (i in imageList.indices){
            val menuList = Menu(imageList[i], titleList[i], durationList[i], ingredientList[i], stepsList[i])
            datalist.add(menuList)
        }

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