package com.emmanuel_rono.intern_test_apk.Presentation

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.emmanuel_rono.intern_test_apk.Post
import com.emmanuel_rono.intern_test_apk.Presentation.MainActivity.Companion.posts
import com.emmanuel_rono.intern_test_apk.R

class Detail_Screen : AppCompatActivity() {
companion object {
    const val EXTRA_POST = "extra_post"
}
private lateinit var title_Tv: TextView
private lateinit var Text_Tv: TextView
@SuppressLint("MissingInflatedId")
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_detail_screen)

    title_Tv = findViewById(R.id.title_tv)
    Text_Tv = findViewById(R.id.Text_tv)

    val post = intent.getParcelableExtra<Post>(posts)
    if (post != null) {
        displayPostDetails(post)
    } else {
        Toast.makeText(this, "Error...", Toast.LENGTH_SHORT).show()
        finish()
    }
}
private fun displayPostDetails(post: Post) {
    title_Tv.text = post.title
    Text_Tv.text = post.body
}
}
