package com.vsga.submissionandroidpemula

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RecipeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe)

        val getData = intent.getParcelableExtra<Menu>("android")
        if(getData != null) {
            val detailTitle : TextView = findViewById(R.id.detailTitle)
            val detailImage : ImageView = findViewById(R.id.detailImage)
            val detailDuration : TextView = findViewById(R.id.detailTime)
            val detailIngredients : TextView = findViewById(R.id.detailIngredients)
            val detailsSteps : TextView = findViewById(R.id.detailDesc)

            detailTitle.text = getData.name
            detailImage.setImageResource(getData.photo)
            detailDuration.text = getData.duration
            detailIngredients.text = getData.dataIngredients
            detailsSteps.text = getData.dataSteps

        }
    }
}