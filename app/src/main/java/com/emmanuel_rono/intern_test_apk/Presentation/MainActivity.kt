package com.emmanuel_rono.intern_test_apk.Presentation

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.emmanuel_rono.intern_test_apk.*

class MainActivity : AppCompatActivity() {
    private lateinit var dataRecyclerview: RecyclerView
    private lateinit var dataViewModel: DataViewModel
    companion object
    {
        //Defining the Key to use for passing data -PutExtra
        const val posts = "the_Posts"
    }
    @SuppressLint("SuspiciousIndentation", "NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dataRecyclerview = findViewById(R.id.postsRecyclerView)
        dataRecyclerview.layoutManager = LinearLayoutManager(this)
        val adapter = PostsAdapter(emptyList()) { post ->
            gotoDetailsScreen(post)
        }
        dataRecyclerview.adapter = adapter
        val repository = PostRepository()
        dataViewModel=ViewModelProvider(this, ViewModelfactory(repository)).get(DataViewModel::class.java)
        dataViewModel.posts.observe(this) { posts ->
            adapter.posts = posts
            adapter.notifyDataSetChanged()
        }
        dataViewModel.get_The_Posts()
    }

        //The function to be invoked -As we navigate to the DetailsScreen
    private fun gotoDetailsScreen(post: Post) {
        val intent = Intent(this, Detail_Screen::class.java)
        intent.putExtra(posts, post)
        startActivity(intent)
    }
}
