package com.randy.bajp2.inject

import com.randy.bajp2.Retrofit.RetrofitConfig
import com.randy.bajp2.models.repository.DataRepository
import com.randy.bajp2.models.repository.LocalRepository
import com.randy.bajp2.models.repository.remote.RemoteRepository

object Injection {
    fun movieRepository(): DataRepository{
        val localRepository = LocalRepository()
        val remoteRepository = RemoteRepository.getInstance(RetrofitConfig)
        return DataRepository.getInstance(localRepository, remoteRepository)!!
    }
}