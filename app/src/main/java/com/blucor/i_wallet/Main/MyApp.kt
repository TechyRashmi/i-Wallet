package com.blucor.i_wallet.Main

import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK

class MyApp : Application() {

    companion object {
        var ctx: Context? = null
        fun newActivity(activity: Activity)
        {
            val i = Intent(ctx, activity::class.java)
            i.setFlags(FLAG_ACTIVITY_NEW_TASK)
            ctx?.startActivity(i)

        }
    }

    override fun onCreate() {
        super.onCreate()
        ctx = applicationContext
    }

}