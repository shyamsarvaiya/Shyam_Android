package com.example.tablayoutex

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class MyAdapter(fm:FragmentManager) : FragmentStatePagerAdapter(fm)
{

    var listFragment:MutableList<Fragment> = ArrayList()
    var listString:MutableList<String> = ArrayList()

    override fun getCount(): Int
    {
       return listFragment.size
    }

    override fun getItem(position: Int): Fragment
    {
        return listFragment.get(position)
    }

    override fun getPageTitle(position: Int): CharSequence?
    {
        return listString.get(position)
    }

    fun adddata(fragment: Fragment,title:String)
    {
        listFragment.add(fragment)
        listString.add(title)
    }

}