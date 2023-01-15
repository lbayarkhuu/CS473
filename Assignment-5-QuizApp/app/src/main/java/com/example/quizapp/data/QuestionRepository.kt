package com.example.quizapp.data

import androidx.lifecycle.LiveData

class QuestionRepository(private val questionDao: QuestionDao) {
    val readAllData: LiveData<List<Question>> = questionDao.readAllData()

    suspend fun addQuestion(question:Question) {
        questionDao.addQuestion(question)
    }
}