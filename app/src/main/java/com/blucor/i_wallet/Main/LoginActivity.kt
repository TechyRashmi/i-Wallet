package com.blucor.i_wallet.Main

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.blucor.i_wallet.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(),View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_in_left)
        llProceed.setOnClickListener(this)


    }

    override fun onClick(p0: View?) {

        when (p0?.id) {
            R.id.llProceed -> MyApp.newActivity(OtpActivity())

            else -> { // Note the block
                print("x is neither 1 nor 2")
            }
        }

    }
}