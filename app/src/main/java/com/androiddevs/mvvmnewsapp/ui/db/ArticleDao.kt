package com.androiddevs.mvvmnewsapp.ui.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.androiddevs.mvvmnewsapp.ui.models.Article

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article): Long

    @Query("SELECT * FROM articles")
    //Live data doesn't work with suspend function
    //Live Data, android architecture. Fragments to suscribe to changes in live data. whenver a da databa in database observe those changes, device rotation
    //Live Data, View Model is not recreated
    fun getAllArticles(): LiveData<List<Article>>
    //whenver an article inside a list changes, notfifies the observer

    @Delete
    suspend fun deleteArticle(article: Article)
}