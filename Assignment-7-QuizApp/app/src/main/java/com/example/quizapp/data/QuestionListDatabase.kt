package com.example.quizapp.data

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*

@Entity(tableName = "question")
data class Question (
    @PrimaryKey val id: Int,
    var body:String = "",
    var answer1:String = "",
    var answer2:String = "",
    var answer3:String = "",
    var answer4:String = "",
    var correct:Int
)

@Dao
interface QuestionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addQuestion(question: Question)

    @Query("SELECT * FROM question ORDER BY id ASC")
    fun readAllData(): LiveData<List<Question>>
}

@Database(entities = [Question::class],version = 1, exportSchema = false)
abstract class QuestionListDatabase: RoomDatabase() {
    abstract fun questionDao(): QuestionDao

    companion object{
        @Volatile
        private var INSTANCE: QuestionListDatabase? = null

        fun getInstance(context: Context):QuestionListDatabase {
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    QuestionListDatabase::class.java,
                    "question_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}