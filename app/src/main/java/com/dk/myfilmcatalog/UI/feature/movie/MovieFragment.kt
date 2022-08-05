package com.dk.myfilmcatalog.UI.feature.movie

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.dk.myfilmcatalog.R
import com.dk.myfilmcatalog.UI.MainActivity
import com.dk.myfilmcatalog.UI.base.BaseFragment
import com.dk.myfilmcatalog.UI.feature.search.SearchMoviesFragment
import com.dk.myfilmcatalog.databinding.FragmentMovieBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MovieFragment : BaseFragment<FragmentMovieBinding>(FragmentMovieBinding::inflate) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(activity != null){
            binding.fabSearch.setOnClickListener { view ->
                view.findNavController().navigate(R.id.action_navigation_movies_to_searchMoviesFragment)
            }
        }

    }

    override fun onResume() {
        super.onResume()

        val navbar = (activity as AppCompatActivity).findViewById<BottomNavigationView>(R.id.nav_view)
        navbar.visibility = View.VISIBLE
    }
}