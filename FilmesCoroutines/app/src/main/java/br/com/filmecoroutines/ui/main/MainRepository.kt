package br.com.filmecoroutines.ui.main

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class MainRepository {

    fun getFilmes(param: (Any) -> Unit): List<Filme> {
        Thread(Runnable {
            Thread.sleep(3000)
            listOf(
                Filme(1,"Título 01"),
                Filme(2,"Título 02")
            )
        }).start()
    }

    suspend fun getFilmesCoroutines(): List<Filme> {
        withContext(Dispatchers.Default) {
            delay(3000)
            listOf(
                Filme(1,"Título 01"),
                Filme(2,"Título 02")
            )
        }
    }

}