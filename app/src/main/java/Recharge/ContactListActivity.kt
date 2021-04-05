package Recharge

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.blucor.i_wallet.R
import kotlinx.android.synthetic.main.activity_contact_list.*

class ContactListActivity : AppCompatActivity() {

    private val contactsViewModel by viewModels<ContactsViewModel>()
    private val CONTACTS_READ_REQ_CODE = 100
    private var filterType: FilterType? = null

    /*  boolean variable for Filtering */
    private val isSearchWithPrefix = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_list)

        init()
    }

    private fun init() {
        filterType = FilterType.NAME

        recyclerview.setLayoutManager(LinearLayoutManager(this));
        val adapter = ContactsAdapter(this)
        recyclerview.adapter = adapter

        contactsViewModel.contactsLiveData.observe(this, Observer {
            adapter.contacts = it
        })

        etSearch.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(
                charSequence: CharSequence,
                arg1: Int,
                arg2: Int,
                arg3: Int
            ) {
                adapter.filter(filterType, charSequence.toString(), isSearchWithPrefix)
            }

            override fun afterTextChanged(editable: Editable) {}
            override fun beforeTextChanged(
                arg0: CharSequence, arg1: Int, arg2: Int,
                arg3: Int
            ) {
            }
        })

        if (hasPermission(Manifest.permission.READ_CONTACTS)) {
            contactsViewModel.fetchContacts()
        } else {
            requestPermissionWithRationale(
                Manifest.permission.READ_CONTACTS, CONTACTS_READ_REQ_CODE, getString(
                    R.string.contact_permission_rationale
                )
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == CONTACTS_READ_REQ_CODE && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            contactsViewModel.fetchContacts()
        }
    }

}