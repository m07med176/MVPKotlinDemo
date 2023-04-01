package com.example.mvpkotlindemo.features.productsFavortie.view

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvpkotlindemo.R
import com.example.mvpkotlindemo.data.model.Product

class FavoriteAdapter(
    private val context: Context,
    private val productArrayList: List<Product>,
    private var onClickToRemove: (product:Product)->Unit

    ) : RecyclerView.Adapter<FavoriteAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_list, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val product = productArrayList[position]
        holder.tvBrand.text = product.brand
        holder.tvDesc.text = product.description
        holder.tvTitle.text = product.title
        holder.tvPrice.text = java.lang.String.valueOf(product.price)
        holder.ratingBar.isEnabled = false
        holder.ratingBar.rating = product.rating?.toFloat()?:0f
        Glide.with(context).load(product.thumbnail).into(holder.imageView)
        holder.callRepo.setOnClickListener {
          onClickToRemove(product)
        }

    }

    override fun getItemCount(): Int {
        return productArrayList.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvBrand: TextView
        var tvDesc: TextView
        var tvTitle: TextView
        var tvPrice: TextView
        var imageView: ImageView
        var ratingBar: RatingBar
        var viewHolder: LinearLayout
        var callRepo: Button

        init {
            tvBrand = itemView.findViewById(R.id.tv_brand)
            tvDesc = itemView.findViewById(R.id.tv_desc)
            tvTitle = itemView.findViewById(R.id.tv_title)
            tvPrice = itemView.findViewById(R.id.tv_price)
            imageView = itemView.findViewById(R.id.imageView)
            ratingBar = itemView.findViewById(R.id.ratingBar)
            viewHolder = itemView.findViewById(R.id.viewHolder)
            callRepo = itemView.findViewById(R.id.btn_call_repo)
            callRepo.text = "remove"
        }
    }

}