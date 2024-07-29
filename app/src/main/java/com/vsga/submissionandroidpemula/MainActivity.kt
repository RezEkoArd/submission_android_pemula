package com.vsga.submissionandroidpemula

import android.content.Intent
import android.os.Bundle
import android.view.MenuInflater
import android.view.MenuItem
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

    override fun onCreateOptionsMenu(menu: android.view.Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem)  : Boolean {
        return when (item.itemId)  {
            R.id.action_profile -> {
                val intent = Intent(this, ProfileActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }


    }

    private fun getData(){

        for (i in imageList.indices){
            val menuList = Menu(imageList[i], titleList[i], durationList[i], ingredientList[i], stepsList[i])
            datalist.add(menuList)
        }

    }


}