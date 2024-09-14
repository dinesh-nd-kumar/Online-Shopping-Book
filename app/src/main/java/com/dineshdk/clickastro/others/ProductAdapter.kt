package com.dineshdk.clickastro.others

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dineshdk.clickastro.models.ProductEntity
import com.dineshdk.clickastro.databinding.RowItemBinding

class ProductAdapter(val clickListener: ItemClickListener, private var productList: List<ProductEntity>)
    : RecyclerView.Adapter<ProductAdapter.UniversityViewHolder>() {
//        private var key : List<String> = productList?.products?.keys!!.map { it }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UniversityViewHolder {
        return UniversityViewHolder(
            RowItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,false))
    }

    override fun getItemCount(): Int {

        if (productList == null)
            return 0
        return productList.size

    }


    override fun onBindViewHolder(holder: UniversityViewHolder, position: Int) {
        val name = productList[position]
        holder.bindData(name)

    }


    inner class UniversityViewHolder(val binding:RowItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bindData(product : ProductEntity){
            binding.apply {
                productnameTextview.text = product.name
                priceTextview.text = "₹ ${product.price}"
                ratingTextview.text = "${product.avg} (${product.soldcount})"
                Glide.with(productImage)
                    .load(product.imagePath.square)
                    .fitCenter()
                    .into(productImage)
                root.setOnClickListener{
                    clickListener.onItemClick(product)
                }
            }
        }

    }
    public interface ItemClickListener{
        public fun onItemClick(p: ProductEntity)
    }
}