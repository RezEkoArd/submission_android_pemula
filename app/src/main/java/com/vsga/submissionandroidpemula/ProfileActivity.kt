package com.vsga.submissionandroidpemula

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val profileImage: ImageView = findViewById(R.id.profile_image)

        // Using Glide untuk membuat gambar bundar
        Glide.with(this)
            .load(R.drawable.profile_img)
            .apply(RequestOptions.circleCropTransform())
            .into(profileImage)
    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        val inflater: MenuInflater = menuInflater
//        inflater.inflate(R.menu.menu_back,menu)
//        return super.onCreateOptionsMenu(menu)
//    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return when (item.itemId) {
//            R.id.action_back -> {
//                // Action saat tombol di klik
//                finish()
//                true
//            }
//            else -> super.onOptionsItemSelected(item)
//        }
//    }

}