package com.example.testkotlinapp.data

object TestObject {
    private var movieList: List<Movie> = arrayListOf(Movie("Forrest Gump", "Beautiful movie!", 9),)

    fun getMovieList(): List<Movie> {
        return movieList
    }


}


