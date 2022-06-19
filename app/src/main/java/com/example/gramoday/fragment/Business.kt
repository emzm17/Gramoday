package com.example.gramoday.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gramoday.ProfileViewModel
import com.example.gramoday.R
import com.example.gramoday.adapter.ProductAdapter
import com.example.gramoday.modal.Product
import com.example.gramoday.modal.Profile
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_business.*
import kotlinx.android.synthetic.main.fragment_business.view.*


class Business : Fragment() {
  private lateinit var adapter:ProductAdapter
  private lateinit var vm: ProfileViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_business, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm= ViewModelProvider(this)[ProfileViewModel::class.java]
        vm.getProfile()
        try {
            vm.user.observe(requireActivity()) {
                tvMname.text=it.business.marketStdName
                tvFname.text=it.business.firmName
                tvSname.text=it.business.mandiShopnum
                adapter = ProductAdapter(requireContext(), it.products)
                rcview.layoutManager = LinearLayoutManager(requireContext())
                rcview.adapter = adapter
            }

        }catch (e:Exception){
            Log.i("error", e.toString())
        }







    }








}