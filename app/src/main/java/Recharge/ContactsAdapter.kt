package Recharge

import android.content.Context
import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.blucor.i_wallet.R
import kotlinx.android.synthetic.main.contact_items.view.*


class ContactsAdapter(context: Context) : RecyclerView.Adapter<ContactsAdapter.MyViewHolder>() {



    var contactlist = mutableListOf<Contact>()
    var filterArrayList = mutableListOf<Contact>()

    val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    var contacts = ArrayList<Contact>()
        set(value) {
            field = value
            contactlist=contacts

            filterArrayList.addAll(contactlist)


            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        return MyViewHolder(layoutInflater.inflate(R.layout.contact_items, parent, false))
    }

    override fun getItemCount() = contacts.size

    fun filter(filterType: FilterType?, charText: String, isSearchWithPrefix: Boolean) {
        //If Filter type is NAME and EMAIL then only do lowercase, else in case of NUMBER no need to do lowercase because of number format
        contactlist.clear()
        //If search query is null or length is 0 then add all filterList items back to arrayList
        if (charText.length == 0) {
            contactlist.addAll(filterArrayList)
        } else {

            //Else if search query is not null do a loop to all filterList items
            for (model in filterArrayList) {

                //Now check the type of search filter
                when (filterType) {
                    FilterType.NAME -> if (isSearchWithPrefix) {
                        //if STARTS WITH radio button is selected then it will match the exact NAME which match with search query
                        if (model.name.startsWith(charText)) contactlist.add(model)
                    } else {
                        //if CONTAINS radio button is selected then it will match the NAME wherever it contains search query
                        if (model.name.contains(charText)) {
                            contactlist.add(model)
                        } else {
                            if (model.numbers[0].trim().replace("\\(", "")
                                    .replace("\\)", "").replace(" ", "").startsWith(charText)
                            ) {
                                contactlist.add(model)
                            } else {
                                //if CONTAINS radio button is selected then it will match the NUMBER wherever it contains search query
                                if (model.numbers[0].trim().replace("\\(", "")
                                        .replace("\\)", "").replace(" ", "")
                                        .contains(charText)
                                ) contactlist.add(model)
                            }
                        }
                    }
                    FilterType.NUMBER -> if (isSearchWithPrefix) {
                        //if STARTS WITH radio button is selected then it will match the exact NUMBER which match with search query
                        if (model.numbers[0].startsWith(charText)) contactlist.add(model)
                    } else {
                        //if CONTAINS radio button is selected then it will match the NUMBER wherever it contains search query
                        if (model.numbers[0].contains(charText)) contactlist.add(model)
                    }
                }
            }
        }
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val contact = contacts[position]

        val builder = StringBuilder()
        val strArray: Array<String> = contact.name.split(" ".toRegex()).toTypedArray()
        val str1: String = strArray.get(0)


        with(holder.itemView) {
            for (s in strArray) {
                val cap = str1.substring(0, 1).toUpperCase()
                    tvAlphabet.setText(cap)
                builder.append("$cap ")
            }
            tvContactName.text=contact.name

            contact.numbers.forEach {
                 tvContactNumber.text=contact.numbers[0]
            }
            if (position % 7 == 0) {
                imageview.setColorFilter(
                    ContextCompat.getColor(
                        context,
                        R.color.color_list1
                    ), PorterDuff.Mode.MULTIPLY
                )
            } else if (position % 7 == 1) {
                imageview.setColorFilter(
                    ContextCompat.getColor(
                        context,
                        R.color.color_list2
                    ), PorterDuff.Mode.MULTIPLY
                )
            } else if (position % 7 == 2) {
                imageview.setColorFilter(
                    ContextCompat.getColor(
                        context,
                        R.color.color_list3
                    ), PorterDuff.Mode.MULTIPLY
                )
            } else if (position % 7 == 3) {
                imageview.setColorFilter(
                    ContextCompat.getColor(
                        context,
                        R.color.color_list4
                    ), PorterDuff.Mode.MULTIPLY
                )
            } else if (position % 7 == 4) {
               imageview.setColorFilter(
                   ContextCompat.getColor(
                       context,
                       R.color.color_list5
                   ), PorterDuff.Mode.MULTIPLY
               )
            } else if (position % 7 == 5) {
                imageview.setColorFilter(
                    ContextCompat.getColor(
                        context,
                        R.color.color_list6
                    ), PorterDuff.Mode.MULTIPLY
                )
            } else if (position % 7 == 6) {
                imageview.setColorFilter(
                    ContextCompat.getColor(
                        context,
                        R.color.color_list7
                    ), PorterDuff.Mode.MULTIPLY
                )
            }

        }
        }


        //Log.e("cont",contact.name)



    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}