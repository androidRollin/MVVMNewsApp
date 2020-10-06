package com.androiddevs.mvvmnewsapp.ui.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.androiddevs.mvvmnewsapp.ui.models.Article

@Database(
    entities = [Article::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class ArticleDatabase : RoomDatabase() {

    //to access or article dao , to access our database function
    abstract fun getArticleDao(): ArticleDao

    companion object{
        @Volatile // see thereads when this changes
        private var instance: ArticleDatabase? = null
        private val LOCK = Any() //synchronize making instance, single

        //whenever we create an instance, this runs
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also{ instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ArticleDatabase::class.java,
                "article_db.db"
            ).build()
    }
}