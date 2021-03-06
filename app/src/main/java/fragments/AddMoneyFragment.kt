package fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import com.blucor.i_wallet.Main.MyApp
import com.blucor.i_wallet.Main.OtpActivity
import com.blucor.i_wallet.R
import kotlinx.android.synthetic.main.fragment_add_money.*
import kotlinx.android.synthetic.main.fragment_add_money.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AddMoneyFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddMoneyFragment : Fragment(), OnClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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

        val view = inflater?.inflate(R.layout.fragment_add_money, container, false)

        view.tv1000.setOnClickListener(this)
        view.tv2000.setOnClickListener(this)
        view.tv3000.setOnClickListener(this)

        // Inflate the layout for this fragment
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AddMoneyFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AddMoneyFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.tv1000 ->etAmt.setText("1000")
            R.id.tv2000 ->etAmt.setText("2000")
            R.id.tv3000 ->etAmt.setText("3000")

            else -> { // Note the block
                print("x is neither 1 nor 2")
            }
        }
    }
}