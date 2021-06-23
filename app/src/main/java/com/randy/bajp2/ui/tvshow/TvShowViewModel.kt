package com.randy.bajp2.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.randy.bajp2.models.repository.DataRepository
import com.randy.bajp2.models.repository.remote.ItemList
import com.randy.bajp2.models.repository.remote.TvShowDetail

class TvShowViewModel(private val dataRepository: DataRepository) : ViewModel() {
    val tvShow: LiveData<List<ItemList>> = dataRepository.getTvShow()
    fun getTvShowDetail(tvId: String): LiveData<TvShowDetail> = dataRepository.getTvShowDetail(tvId)
}