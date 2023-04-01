package com.example.mvpkotlindemo.features.productsList.presenter

import com.example.mvpkotlindemo.data.RepositoryInteface
import com.example.mvpkotlindemo.data.model.Product
import com.example.mvpkotlindemo.data.network.NetworkCallBack
import com.example.mvpkotlindemo.features.productsList.view.ProductsListViewInterface

class ProductsListPresenter(
    private var _repository: RepositoryInteface,
    private val _viewInterface:ProductsListViewInterface
    ):ProductsListInterface {

    override fun getProudects() {
        _repository.getProudects(object :NetworkCallBack{
            override fun onSuccessResult(products: List<Product>) {
                _viewInterface.remoteSuccessDataCallBack(products)
            }
            override fun onFailureResult(message: String) {
               _viewInterface.remoteErrorDataCallBack(message)
            }
        })
    }

    override suspend fun insertProudect(proudect: Product) {
        _repository.insertProudect(proudect)
    }
}