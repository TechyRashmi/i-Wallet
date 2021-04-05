package Electricity

import DTH.DTHActivity
import DTH.DTHModel
import DTH.DTHRechargeActivity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.blucor.i_wallet.Main.MyApp
import com.blucor.i_wallet.R
import kotlinx.android.synthetic.main.activity_d_t_h.*
import kotlinx.android.synthetic.main.activity_d_t_h.recylerviewDTH
import kotlinx.android.synthetic.main.activity_electricity_operator.*
import kotlinx.android.synthetic.main.inflate_dth_list.view.*
import java.util.ArrayList

class ElectricityOperator : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_electricity_operator)

        var adapter_dth = ElectricityAdapter( this)
        recyclerviewElectricity.setLayoutManager(LinearLayoutManager(this))
        recyclerviewElectricity.setAdapter(adapter_dth)

    }

    
    class ElectricityAdapter : RecyclerView.Adapter<Holder> {
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
                    R.layout.electricity_items,
                    parent,
                    false
                )
            )
        }

        override fun onBindViewHolder(holder: Holder, position: Int) {

//            with(holder.itemView) {
//                tvDth.setText(data.get(position).name)
//                ivDth.setImageResource(data.get(position).getImage())
//
//
//                holder.itemView.setOnClickListener{
//
//                }
//            }



        }

        override fun getItemCount(): Int {
            return 5
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