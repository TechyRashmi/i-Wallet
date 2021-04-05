package DTH

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.blucor.i_wallet.Main.MyApp
import com.blucor.i_wallet.R
import kotlinx.android.synthetic.main.activity_d_t_h.*
import kotlinx.android.synthetic.main.contact_items.view.*
import kotlinx.android.synthetic.main.inflate_dth_list.view.*
import java.util.*

class DTHActivity : AppCompatActivity() {

    //Arraylist
    var dthlist = ArrayList<DTHModel>()

    //Model
    var dthModel: DTHModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_d_t_h)

        dthModel = DTHModel(R.drawable.airtel_dth, "Airtel Digital TV")
        dthlist.add(dthModel!!)

        dthModel = DTHModel(R.drawable.dish_dth, "Dish TV")
        dthlist.add(dthModel!!)

        dthModel = DTHModel(R.drawable.d2h_dth, "D2H")
        dthlist.add(dthModel!!)

        dthModel = DTHModel(R.drawable.reliance_digital_dth, "Reliance Digital TV")
        dthlist.add(dthModel!!)

        dthModel = DTHModel(R.drawable.sundirect_dth, "SUN Direct")
        dthlist.add(dthModel!!)

        dthModel = DTHModel(R.drawable.tata_sky_dth, "Tata Sky")
        dthlist.add(dthModel!!)

        var adapter_dth = DTHAdapter(dthlist, this)
        recylerviewDTH.setLayoutManager(LinearLayoutManager(this))
        recylerviewDTH.setAdapter(adapter_dth)

    }


    class DTHAdapter : RecyclerView.Adapter<Holder> {
        var data = ArrayList<DTHModel>()
        lateinit var image: IntArray
        lateinit var array: Array<String>
        lateinit var ctx: Context


        constructor(favList: ArrayList<DTHModel>, ctx: Context) {
            data = favList
            this.ctx=ctx

        }

        constructor(image: IntArray, array: Array<String>) {
            this.image = image
            this.array = array
        }

        constructor(ctx: Context)
        {
            this.ctx=ctx
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
            return Holder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.inflate_dth_list,
                    parent,
                    false
                )
            )
        }

        override fun onBindViewHolder(holder: Holder, position: Int) {

            with(holder.itemView) {
                tvDth.setText(data.get(position).name)
               ivDth.setImageResource(data.get(position).getImage())


                holder.itemView.setOnClickListener{
                    MyApp.newActivity(DTHRechargeActivity())
                }
                }



        }

        override fun getItemCount(): Int {
            return data.size
        }

        override fun getItemViewType(position: Int): Int {
            return position
        }
    }

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {



        init {




        }
    }
}