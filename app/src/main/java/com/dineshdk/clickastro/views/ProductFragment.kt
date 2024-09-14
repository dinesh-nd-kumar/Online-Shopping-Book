package com.dineshdk.clickastro.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.dineshdk.clickastro.models.ShopViewModel
import com.dineshdk.clickastro.databinding.FragmentProductBinding


class ProductFragment : Fragment() {

    private var _binding: FragmentProductBinding? = null
    private val binding get() = _binding!!

    private var shopViewModel: ShopViewModel? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentProductBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        shopViewModel = ViewModelProvider(requireActivity()).get(ShopViewModel::class.java)
        val p = shopViewModel?.getProduct()!!
            binding.apply {
                Glide.with(productImageView)
                    .load(p.imagePath.wide)
                    .fitCenter()
                    .into(productImageView)

                productNameTextView.text = p.name
                priceTextView.text = "₹ ${p.price}"
                description.text = p.description
                ratingTextview.text = "${p.avg} (${p.soldcount})"
                availLang.text = p.availableLanguages.toString()

            }

    }

}