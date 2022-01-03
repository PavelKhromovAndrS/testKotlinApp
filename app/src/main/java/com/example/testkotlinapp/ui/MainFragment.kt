package com.example.testkotlinapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
import com.example.testkotlinapp.R
import com.example.testkotlinapp.data.Movie
import com.example.testkotlinapp.data.TestObject

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button: Button = view.findViewById(R.id.first_kotlin_button)
        val button1: Button = view.findViewById(R.id.navigation_button)
        button.setOnClickListener(View.OnClickListener {
            Toast.makeText(context, "Hello Kotta", Toast.LENGTH_LONG).show()
            showMovie()
        })

        button.setOnLongClickListener(View.OnLongClickListener {
            Toast.makeText(context, showMovieLong(), Toast.LENGTH_LONG).show()
            true
        })

        button1.setOnClickListener(View.OnClickListener {
            NavHostFragment.findNavController(this)
                .navigate(R.id.action_mainFragment_to_otherFragment);
        })
    }

    private fun showMovieLong(): String {
        var movieList: List<Movie> = TestObject.getMovieList()
        return movieList[0].title
    }

    private fun showMovie() {
        val movie1 = Movie("Matrix:Trilogy", "Beautiful movies!", 10)
        val moviesListRoot: LinearLayout = view?.findViewById(R.id.movies_root)!!

        val itemView: View =
            LayoutInflater.from(context).inflate(R.layout.item_movie, moviesListRoot, false)

        val movieTitle: TextView = itemView.findViewById(R.id.movie_title)
        movieTitle.setText(movie1.title)

        val movieDescription: TextView = itemView.findViewById(R.id.movie_description)
        movieDescription.setText(movie1.description)

        val movieRating: TextView = itemView.findViewById(R.id.movie_rating)
        movieRating.setText(movie1.rating.toString())

        moviesListRoot.addView(itemView)
    }
}