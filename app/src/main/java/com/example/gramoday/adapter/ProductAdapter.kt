package com.example.gramoday.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gramoday.R
import com.example.gramoday.modal.Post
import com.example.gramoday.modal.Product
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_business.view.*
import kotlinx.android.synthetic.main.listitem.view.*

import java.text.SimpleDateFormat

class ProductAdapter(private val context: Context, private val list: List<Product>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewModel>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewModel {
        val v = LayoutInflater.from(context).inflate(R.layout.listitem, parent, false)
        return ProductViewModel(v)
    }

    override fun onBindViewHolder(holder: ProductViewModel, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ProductViewModel(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SetTextI18n", "SimpleDateFormat")
        fun bind(item: Product) = with(itemView) {
            tvAddress.text =
                item.posts[0].marketStdName + "," + item.posts[0].loclevel3Name + "," + item.posts[0]
                    .loclevel2ShortName
            val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
            tvPrice.text =
                item.posts[0].computed.highestAvgPriceVarietyGrade.minPrice.toString() + "-" +
                        item.posts[0].computed.highestAvgPriceVarietyGrade.maxPrice.toString() + "/" +
                        item.posts[0].rawPriceConvFctr + " " + item.posts[0].rawReportPriceUnit
            tvVeg.text = item.posts[0].cmdtyStdName + " " + item.posts[0].marketType + " " + "Mandi"
            Picasso.get().load(item.picUrl).placeholder(R.drawable.avatar).into(itemImage)
        }
    }


}