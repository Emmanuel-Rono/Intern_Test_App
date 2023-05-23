package com.emmanuel_rono.intern_test_apk

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class DataViewModel(private val repository: PostRepository) : ViewModel() {
    private val Posts = MutableLiveData<List<Post>>()
    val posts: LiveData<List<Post>> get() = Posts

    //Function to help me get Posts and update the posts
    fun get_The_Posts() {
        viewModelScope.launch {
            val fetchedPosts = repository.getPosts()
            Posts.value = fetchedPosts
        }
    }
}
