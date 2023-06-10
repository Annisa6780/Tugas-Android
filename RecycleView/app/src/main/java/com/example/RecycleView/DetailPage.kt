package com.example.RecycleView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailPage : AppCompatActivity() {

    companion object {
        const val EXTRA_IMAGE = "extra_image"
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_DESC = "extra_desc"
        const val EXTRA_DETAIL = "extra_detail"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_page)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvItemName: TextView = findViewById(R.id.tv_item_name)
        val tvItemDescription: TextView = findViewById(R.id.tv_item_description)
        val ivItemPhoto: ImageView = findViewById(R.id.img_item_photo)
        val tvItemDetailDesc: TextView = findViewById(R.id.tv_item_detaildesc)

        val name = intent.getStringExtra(EXTRA_NAME)
        val desc = intent.getStringExtra(EXTRA_DESC)
        val detail = intent.getStringExtra(EXTRA_DETAIL)
        val photo = intent.getIntExtra(EXTRA_IMAGE, 0)

        tvItemName.text = name
        tvItemDescription.text = desc
        tvItemDetailDesc.text = detail

        Glide.with(this@DetailPage)
            .load(photo)
            .into(ivItemPhoto)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}