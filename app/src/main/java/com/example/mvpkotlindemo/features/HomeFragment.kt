package com.example.mvpkotlindemo.features

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.example.mvpkotlindemo.R

class HomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navHostFragment =
        requireActivity().supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        view.findViewById<Button>(R.id.productsFavBtn).setOnClickListener {
            navController.navigate(R.id.action_homeFragment_to_favoriteFragment)
        }

        view.findViewById<Button>(R.id.productsListBtn).setOnClickListener {
            navController.navigate(R.id.action_homeFragment_to_productsListFragment)

        }
    }

}