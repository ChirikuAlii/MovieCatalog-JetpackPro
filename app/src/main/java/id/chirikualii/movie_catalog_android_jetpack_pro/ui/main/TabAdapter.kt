package id.chirikualii.movie_catalog_android_jetpack_pro.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 * Create by Chiriku Alii on 6/15/21
 * github.com/chirikualii
 */
class TabAdapter(private val list: List<Fragment>, fa: FragmentActivity) :
    FragmentStateAdapter(fa) {

    override fun getItemCount(): Int = list.size

    override fun createFragment(position: Int): Fragment = list[position]
}