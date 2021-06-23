package com.randy.bajp2.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.randy.bajp2.models.repository.DataRepository
import com.randy.bajp2.models.repository.remote.ItemList

class MovieViewModel(private val dataRepository: DataRepository) : ViewModel() {
    val movie: LiveData<List<ItemList>> = dataRepository.getMovie()
    fun getMovieDetail(movieId: String): LiveData<ItemList> = dataRepository.getMovieDetail(movieId)
}