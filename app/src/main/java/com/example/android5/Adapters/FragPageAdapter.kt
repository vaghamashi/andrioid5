package com.example.android5.Adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.android5.Fragments.CallFragment
import com.example.android5.Fragments.ChatFragment
import com.example.android5.Fragments.StatusFragment

class FragPageAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    var titles = arrayOf("CHATS","STATUS","CALLS")
    var frags = arrayOf(ChatFragment(), StatusFragment(), CallFragment())


    override fun getCount(): Int {
        return frags.size
    }

    override fun getItem(position: Int): Fragment {
        return frags.get(position)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titles.get(position)
    }

}