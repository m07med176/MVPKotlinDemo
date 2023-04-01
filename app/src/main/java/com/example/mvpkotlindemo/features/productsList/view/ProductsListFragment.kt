package com.example.mvpkotlindemo.features.productsList.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.mvpkotlindemo.R
import com.example.mvpkotlindemo.data.Repository
import com.example.mvpkotlindemo.data.model.Product
import com.example.mvpkotlindemo.features.productsList.presenter.ProductsListInterface
import com.example.mvpkotlindemo.features.productsList.presenter.ProductsListPresenter
import kotlinx.coroutines.launch

class ProductsListFragment : Fragment(),ProductsListViewInterface {

    private lateinit var _presenter:ProductsListInterface
    private lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_products_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerProducts)
        val repository = Repository.getInstance(requireContext())
        _presenter = ProductsListPresenter(repository,this)
        _presenter.getProudects()
    }

    override fun remoteSuccessDataCallBack(products: List<Product>) {
       val adapter = ProductsListAdapter(requireContext(),products){product ->
           lifecycleScope.launch {
               _presenter.insertProudect(product)
               Toast.makeText(requireContext(), "Item Inserted", Toast.LENGTH_SHORT).show()

           }
       }
        recyclerView.adapter = adapter
    }

    override fun remoteErrorDataCallBack(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}