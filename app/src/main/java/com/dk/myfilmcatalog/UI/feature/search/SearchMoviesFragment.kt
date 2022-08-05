package com.dk.myfilmcatalog.UI.feature.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.dk.myfilmcatalog.R
import com.dk.myfilmcatalog.UI.base.BaseFragment
import com.dk.myfilmcatalog.databinding.FragmentMovieBinding
import com.dk.myfilmcatalog.databinding.FragmentSearchMoviesBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class SearchMoviesFragment : BaseFragment<FragmentSearchMoviesBinding>(FragmentSearchMoviesBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(activity != null){
            val navbar = (activity as AppCompatActivity).findViewById<BottomNavigationView>(R.id.nav_view)
            navbar.visibility = View.GONE

            binding.search.onActionViewExpanded()
        }
    }
}