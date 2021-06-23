package com.randy.bajp2.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.randy.bajp2.inject.Injection
import com.randy.bajp2.models.repository.DataRepository
import com.randy.bajp2.ui.movie.MovieViewModel
import com.randy.bajp2.ui.tvshow.TvShowViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val dataRepository: DataRepository): ViewModelProvider.NewInstanceFactory() {
    companion object{
        @Volatile
        private var INSTANCE: ViewModelFactory? = null

        fun getInstance(): ViewModelFactory? {
            if (INSTANCE == null){
                synchronized(ViewModelFactory::class.java){
                    if (INSTANCE == null)
                        INSTANCE = ViewModelFactory(Injection.movieRepository())
                }
            }
            return INSTANCE
        }
    }


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when{
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> MovieViewModel(dataRepository) as T
            modelClass.isAssignableFrom(TvShowViewModel::class.java) -> TvShowViewModel(dataRepository) as T
            else -> throw IllegalArgumentException("Unknown ViewModel: " + modelClass.name)
        }
    }
}