package com.randy.bajp2.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.randy.bajp2.models.repository.LocalRepository
import com.randy.bajp2.models.repository.remote.ItemList
import com.randy.bajp2.models.repository.remote.RemoteRepository
import com.randy.bajp2.models.repository.remote.TvShowDetail
import com.randy.bajp2.models.source.DataSource

open class FakeDataRepository(private val localRepository: LocalRepository, private val remoteRepository: RemoteRepository): DataSource {
    override fun getMovie(): LiveData<List<ItemList>> {
        val movieList = MutableLiveData<List<ItemList>>()
        remoteRepository.getMovie(object : RemoteRepository.GetMovieCallback{
            override fun onResponse(movieResponse: List<ItemList>) {
                movieList.postValue(movieResponse)
            }
        })
        return movieList
    }

    override fun getMovieDetail(movieId: String): LiveData<ItemList> {
        val movieDetail = MutableLiveData<ItemList>()
        remoteRepository.getMovieDetail(movieId, object : RemoteRepository.GetMovieDetailCallback{
            override fun onResponse(movieDetailResponse: ItemList) {
                movieDetail.postValue(movieDetailResponse)
            }
        })
        return movieDetail
    }

    override fun getTvShow(): LiveData<List<ItemList>> {
        val tvShowList = MutableLiveData<List<ItemList>>()
        remoteRepository.getTvShow(object: RemoteRepository.GetTvShowCallback{
            override fun onResponse(tvShowResponse: List<ItemList>) {
                tvShowList.postValue(tvShowResponse)
            }
        })
        return  tvShowList
    }

    override fun getTvShowDetail(tvShowId: String): LiveData<TvShowDetail> {
        val tvShowDetail = MutableLiveData<TvShowDetail>()
        remoteRepository.getTvShowDetail(tvShowId, object : RemoteRepository.GetTvShowDetailCallback{
            override fun onResponse(tvShowDetailResponse: TvShowDetail) {
                tvShowDetail.postValue(tvShowDetailResponse)
            }
        })
        return tvShowDetail
    }
}