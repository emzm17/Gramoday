package com.example.gramoday.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fm:FragmentManager):FragmentStatePagerAdapter(fm) {

    private var list= arrayListOf<Fragment>()
    private var title= arrayListOf<String>()

    fun add(f:Fragment,t:String){
         list.add(f)
         title.add(t)
    }

    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Fragment {
        return list[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return title[position]
    }
}