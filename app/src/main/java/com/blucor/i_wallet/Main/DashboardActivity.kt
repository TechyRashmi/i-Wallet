package com.blucor.i_wallet.Main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.View.OnClickListener
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

import com.blucor.i_wallet.R
import fragments.AddMoneyFragment
import fragments.DashboardFragment
import fragments.OrderFragment
import fragments.ProfileFragment
import kotlinx.android.synthetic.main.activity_dashboard.*


class DashboardActivity : AppCompatActivity(), OnClickListener {

    lateinit var drawer: DrawerLayout
    lateinit var llProfile: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_dashboard)


        setUI()

        iv_menu.setOnClickListener(this)

        replaceFragment(DashboardFragment())
    }


    fun setUI()
    {
        tvHeaderText=findViewById(R.id.tvHeaderText)
        iv_menu=findViewById(R.id.iv_menu)
        drawer=findViewById(R.id.drawer_layout);
        llProfile=findViewById(R.id.llProfile);
        llProfile.setOnClickListener(this)
        llWalet.setOnClickListener(this)
        llOrder.setOnClickListener(this)


    }

    companion object{
    lateinit var tvHeaderText : TextView
    lateinit var iv_menu : ImageView
}


    fun closedrawer()
    {
        drawer.closeDrawer(Gravity.LEFT)
    }

    //Load  fragment
    fun replaceFragment(fragment: Fragment) {
        val newFragment: Fragment = fragment
        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        ft.replace(R.id.main_fragment_container, newFragment).commit()

        if(drawer.isDrawerOpen(Gravity.LEFT))
        {
            closedrawer()
        }

    }

    override fun onClick(p0: View?) {

        when (p0?.id) {
            R.id.iv_menu     -> drawer.openDrawer(Gravity.LEFT)
            R.id.llProfile     -> replaceFragment(ProfileFragment())
            R.id.llWalet     -> replaceFragment(AddMoneyFragment())
            R.id.llOrder     -> replaceFragment(OrderFragment())
            else -> { // Note the block
                print("x is neither 1 nor 2")
            }
        }


    }
}