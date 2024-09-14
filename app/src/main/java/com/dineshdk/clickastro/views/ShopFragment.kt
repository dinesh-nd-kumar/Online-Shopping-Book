package com.dineshdk.clickastro.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.dineshdk.clickastro.R
import com.dineshdk.clickastro.models.ShopViewModel
import com.dineshdk.clickastro.databinding.FragmentShopBinding
import com.dineshdk.clickastro.models.ProductEntity
import com.dineshdk.clickastro.others.ProductAdapter

class ShopFragment : Fragment(), ProductAdapter.ItemClickListener {

    private var _binding: FragmentShopBinding? = null
    private val binding get() = _binding!!
    private var shopViewModel: ShopViewModel? = null

    private lateinit var productAdapter: ProductAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentShopBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        shopViewModel = ViewModelProvider(requireActivity()).get(ShopViewModel::class.java)
        shopViewModel!!.loadData(requireContext())
        shopViewModel!!.getProductLiveData().observe(viewLifecycleOwner){
            setRecycler(it)
            productAdapter.notifyDataSetChanged()

        }

    }
    private fun setRecycler(productList: List<ProductEntity>?){
        binding.rvProducts.apply {
            productAdapter = ProductAdapter(this@ShopFragment,productList!!)
            adapter = productAdapter
            addItemDecoration(
                DividerItemDecoration(
                    context,
                    DividerItemDecoration.HORIZONTAL
                )
            )
            addItemDecoration(
                DividerItemDecoration(
                    context,
                    DividerItemDecoration.VERTICAL
                )
            )

        }
    }



    override fun onItemClick(p: ProductEntity) {
        shopViewModel!!.setProduct(p)
        findNavController().navigate(R.id.action_shopFragment_to_productFragment)

    }
}