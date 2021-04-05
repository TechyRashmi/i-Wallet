package com.blucor.i_wallet.Main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.blucor.i_wallet.R
import kotlinx.android.synthetic.main.activity_otp.*

class OtpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp)
        overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_in_left)

        tvSubmit.setOnClickListener{
            MyApp.newActivity(DashboardActivity())
        }

    }
}