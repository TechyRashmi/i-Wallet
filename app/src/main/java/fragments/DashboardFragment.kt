package fragments

import DTH.DTHActivity
import Electricity.ElectricityOperator
import Recharge.ContactListActivity
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager.widget.ViewPager
import com.blucor.i_wallet.Main.DashboardActivity
import com.blucor.i_wallet.Main.MyApp
import com.blucor.i_wallet.Main.OtpActivity
import com.blucor.i_wallet.R
import com.blucor.steamersindia.adapter.CardPagerAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.android.synthetic.main.fragment_dashboard.view.*
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class DashboardFragment : Fragment() , OnClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    //Int
    var currentPage = 0

    //timer
    var timer: Timer? = null

    //long
    val DELAY_MS: Long = 1000
    val PERIOD_MS: Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view = inflater?.inflate(R.layout.fragment_dashboard, container, false)


        //onclicllistner
        view. rrRecharge.setOnClickListener(this)
        view.rrDTH.setOnClickListener(this)
        view.  rrElectricity.setOnClickListener(this)





        var mViewPager: ViewPager? =view.findViewById(R.id.myviewpager)

        //Tablayout
        val tabLayout: TabLayout? = view.findViewById(R.id.tabDots)

        tabLayout!!.setupWithViewPager(mViewPager, true)
        val NUM_PAGES = 4
        val handler = Handler()
        val Update = Runnable {
            if (currentPage == NUM_PAGES - 1) {
                currentPage = 0
            }
            mViewPager!!.setCurrentItem(currentPage++, true)
        }



        timer = Timer()
        timer!!.schedule(object : TimerTask() {
            override fun run() {
                handler.post(Update)
            }
        }, DELAY_MS, PERIOD_MS)


        val mCardPagerAdapter: CardPagerAdapter = object : CardPagerAdapter(
                requireActivity(),
                mResources
        ) {
            override fun onCategoryClick(view: View?, str: String?) {}
        }

        mViewPager!!.adapter = mCardPagerAdapter
        mViewPager!!.offscreenPageLimit = 2
        mViewPager!!.clipToPadding = true
        mViewPager!!.setCurrentItem(1, true)
        mViewPager!!.pageMargin = 10


        //SetHeadertext
        DashboardActivity.tvHeaderText.text="Dashboard"

        return view
    }

    companion object {

        //Images
        private val mResources = intArrayOf(
                R.drawable.page1,
                R.drawable.page2,
                R.drawable.page3,

        )

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DashboardFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DashboardFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onClick(p0: View?) {

        when (p0?.id) {
            R.id.rrRecharge -> MyApp.newActivity(ContactListActivity())
            R.id.rrDTH -> MyApp.newActivity(DTHActivity())
            R.id.rrElectricity -> MyApp.newActivity(ElectricityOperator())
            else -> {
                print("x is neither 1 nor 2")
            }
        }
    }

    //Load  fragment
    fun replaceFragment(fragment: Fragment) {
        val newFragment: Fragment = fragment
        val ft: FragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
        ft.replace(R.id.main_fragment_container, newFragment).commit()

    }
}