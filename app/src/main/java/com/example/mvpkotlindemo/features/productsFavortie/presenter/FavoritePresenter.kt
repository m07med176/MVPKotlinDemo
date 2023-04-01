package com.example.mvpkotlindemo.features.productsFavortie.presenter

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import com.example.mvpkotlindemo.data.RepositoryInteface
import com.example.mvpkotlindemo.data.model.Product
import com.example.mvpkotlindemo.features.productsFavortie.view.FavoriteViewInterface

class FavoritePresenter(
    private var _repository:RepositoryInteface,
    private val _viewInterface:FavoriteViewInterface
    ):FavoritePresenterInterface {


    override suspend fun getAllProudects(lifecycleOwner: LifecycleOwner){
        _repository.getAllProudects().observe(lifecycleOwner){products->
            _viewInterface.favoriteDataCallBack(products)
        }
    }

    override suspend fun deleteProudect(proudect: Product) {
        _repository.deleteProudect(proudect)
    }
}