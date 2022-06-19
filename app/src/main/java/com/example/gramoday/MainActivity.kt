package com.example.gramoday

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.gramoday.adapter.ViewPagerAdapter
import com.example.gramoday.fragment.Business
import com.example.gramoday.fragment.Review
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_business.*


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var vm: ProfileViewModel
    private lateinit var adapter: ViewPagerAdapter

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


        adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.apply {
            add(Business(), "Business")
            add(Review(), "Review")
        }
        viewpager.adapter = adapter
        tablayout.setupWithViewPager(viewpager)
        vm = ViewModelProvider(this)[ProfileViewModel::class.java]
        vm.getProfile()
        val name = findViewById<TextView>(R.id.tvName)
        try {
            vm.user.observe(this) {
                name.text = it.name
                tvCity.text = it.loclevel3Name + "," + it.loclevel2Name
                tvlang.text = "Speaks English"

            }

        } catch (e: Exception) {
            Log.i("ERROR", e.toString())
        }
        clickListener()


    }


    private fun clickListener() {
        btnConnect.setOnClickListener(this)
        btnContact.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.btnConnect -> {

            }
            R.id.btnContact -> {

            }
        }
    }
}