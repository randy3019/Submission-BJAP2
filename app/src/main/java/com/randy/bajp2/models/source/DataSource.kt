package com.randy.bajp2.models.source

import androidx.lifecycle.LiveData
import com.randy.bajp2.models.repository.remote.ItemList
import com.randy.bajp2.models.repository.remote.TvShowDetail

interface DataSource {
    fun getMovie(): LiveData<List<ItemList>>
    fun getMovieDetail(movieId: String): LiveData<ItemList>
    fun getTvShow(): LiveData<List<ItemList>>
    fun getTvShowDetail(tvShowId: String): LiveData<TvShowDetail>
}