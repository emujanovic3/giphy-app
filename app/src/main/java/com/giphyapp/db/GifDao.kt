package com.giphyapp.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.giphyapp.models.Gif

@Dao
interface GifDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(gif: Gif): Long

    @Query("SELECT * FROM gifs")
    fun getGifs(): LiveData<List<Gif>>
}