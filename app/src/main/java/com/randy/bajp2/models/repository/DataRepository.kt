package com.randy.bajp2.models.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.randy.bajp2.models.source.DataSource
import com.randy.bajp2.models.repository.remote.ItemList
import com.randy.bajp2.models.repository.remote.RemoteRepository
import com.randy.bajp2.models.repository.remote.TvShowDetail

class DataRepository(localRepository: LocalRepository, private val remoteRepository: RemoteRepository): DataSource {

    companion object{
        @Volatile
        private var INSTANCE: DataRepository? = null

        fun getInstance(localRepository: LocalRepository, remoteRepository: RemoteRepository): DataRepository?{
            if (INSTANCE == null){
                synchronized(DataRepository::class.java){
                    if (INSTANCE == null)
                        INSTANCE = DataRepository(localRepository, remoteRepository)
                }
            }
            return INSTANCE
        }
    }

    override fun getMovie(): LiveData<List<ItemList>> {
        val movieLists = MutableLiveData<List<ItemList>>()
        remoteRepository.getMovie(object: RemoteRepository.GetMovieCallback{
            override fun onResponse(movieResponse: List<ItemList>) {
                movieLists.postValue(movieResponse)
            }

        })
        return movieLists
    }

    override fun getMovieDetail(movieId: String): LiveData<ItemList> {
        val movieDetail = MutableLiveData<ItemList>()
        remoteRepository.getMovieDetail(movieId, object: RemoteRepository.GetMovieDetailCallback{
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
        return tvShowList
    }

    override fun getTvShowDetail(tvShowId: String): LiveData<TvShowDetail> {
        val tvShowDetail = MutableLiveData<TvShowDetail>()
        remoteRepository.getTvShowDetail(tvShowId, object: RemoteRepository.GetTvShowDetailCallback{
            override fun onResponse(tvShowDetailResponse: TvShowDetail) {
                tvShowDetail.postValue(tvShowDetailResponse)
            }

        })
        return tvShowDetail
    }
}