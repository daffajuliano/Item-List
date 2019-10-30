package com.djlabs.itemlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.viewpager.widget.ViewPager
import com.djlabs.itemlist.adapter.MainViewPagerAdapter
import com.djlabs.itemlist.fragment.EventFragment
import com.djlabs.itemlist.fragment.ShoppingFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager : ViewPager

    private lateinit var eventFragment : EventFragment
    private lateinit var shoppingFragment: ShoppingFragment

    var prevMenuItem: MenuItem? = null

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.menu_bottom_event -> {
                viewPager.setCurrentItem(0)
                return@OnNavigationItemSelectedListener false
            }
            R.id.menu_bottom_shopping -> {
                viewPager.setCurrentItem(1)
                return@OnNavigationItemSelectedListener false
            }
        }
        true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.main_view_pager)
        val navigationView = findViewById<BottomNavigationView>(R.id.main_bottom_nav)
        navigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        viewPager.addOnPageChangeListener(SimpleOnPageChangeListener(navigationView, prevMenuItem))

        setupViewPager(viewPager)

    }

    private fun setupViewPager(viewPager: ViewPager) {
        val mainViewPagerAdapter = MainViewPagerAdapter(supportFragmentManager, 1);
        eventFragment = EventFragment()
        shoppingFragment = ShoppingFragment()

        mainViewPagerAdapter.addFragment(eventFragment)
        mainViewPagerAdapter.addFragment(shoppingFragment)

        viewPager.adapter = mainViewPagerAdapter
    }

    class SimpleOnPageChangeListener : ViewPager.OnPageChangeListener {
        var navigationView : BottomNavigationView
        var prevMenuItem: MenuItem?

        constructor(navigationView: BottomNavigationView, prevMenuItem: MenuItem?){
            this.navigationView = navigationView
            this.prevMenuItem = prevMenuItem
        }


        override fun onPageScrollStateChanged(state: Int) {}

        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
        ) {}

        override fun onPageSelected(position: Int) {
            if (prevMenuItem != null) {
                prevMenuItem!!.setChecked(false)
            } else {
                navigationView.menu.getItem(0).setChecked(true)
            }
            navigationView.menu.getItem(position).setChecked(true)
            prevMenuItem = navigationView.menu.getItem(position)
        }

    }

}
