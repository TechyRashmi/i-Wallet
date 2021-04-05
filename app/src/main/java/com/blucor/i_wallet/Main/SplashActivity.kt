package com.blucor.i_wallet.Main

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.blucor.i_wallet.R
import kotlinx.android.synthetic.main.activity_main.*

class SplashActivity : AppCompatActivity() {

    private val SPLASH_DELAY: Long = 1000 //3 seconds
    private var mDelayHandler: Handler? = null
    private var progressBarStatus = 0
    var dummy:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mDelayHandler = Handler()
        //Navigate with delay
        mDelayHandler!!.postDelayed(mRunnable, SPLASH_DELAY)



        val handler = Handler()
        handler.postDelayed({
            ivLogo.setVisibility(View.VISIBLE)
            val animSlide = AnimationUtils.loadAnimation(
                applicationContext,
                R.anim.fade_in
            )
            ivLogo.startAnimation(animSlide)
        }, 1000)



    }
    private fun launchMainActivity() {
        var intent = Intent(this, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
        this.finish()
        mDelayHandler!!.removeCallbacks(mRunnable)

    }

    private val mRunnable: Runnable = Runnable {

        Thread(Runnable {
            while (progressBarStatus < 100) {
                // performing some dummy operation
                try {
                    dummy = dummy+25
                    Thread.sleep(1000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
                // tracking progress
                progressBarStatus = dummy

                // Updating the progress bar
                splash_screen_progress_bar.progress = progressBarStatus
            }

            //splash_screen_progress_bar.setProgress(10)

            launchMainActivity()


        }).start()
    }


    override fun onDestroy() {
        if (mDelayHandler != null) {
            mDelayHandler!!.removeCallbacks(mRunnable)
        }

        super.onDestroy()
    }
}