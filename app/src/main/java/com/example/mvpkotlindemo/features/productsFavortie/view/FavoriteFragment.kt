package com.example.mvpkotlindemo.features.productsFavortie.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.mvpkotlindemo.R
import com.example.mvpkotlindemo.data.Repository
import com.example.mvpkotlindemo.data.model.Product
import com.example.mvpkotlindemo.features.productsFavortie.presenter.FavoritePresenter
import kotlinx.coroutines.launch

class FavoriteFragment : Fragment(),FavoriteViewInterface {

    private lateinit var _presenter:FavoritePresenter
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerProductsFav)
        val repository = Repository.getInstance(requireContext())
        _presenter = FavoritePresenter(repository,this)
        _presenter.getAllProudects(this)
    }

    override fun favoriteDataCallBack(products: List<Product>) {
       val adapter = FavoriteAdapter(requireContext(),products){product ->
           lifecycleScope.launch{
               _presenter.deleteProudect(product)

           }
       }

        recyclerView.adapter = adapter
    }
}