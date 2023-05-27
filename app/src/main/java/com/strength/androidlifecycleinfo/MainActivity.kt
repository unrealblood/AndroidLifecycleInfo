package com.strength.androidlifecycleinfo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.PersistableBundle
import android.widget.Button
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private lateinit var shareButton: Button
    private lateinit var myTimer : CountDownTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        shareButton = findViewById(R.id.share_button_MA)
        shareButton.setOnClickListener {
            var shareIntent = Intent().apply {
                action = Intent.ACTION_SEND
                type = "text/plain"
            }

            val sendIntent = Intent.createChooser(shareIntent, null)
            startActivity(sendIntent)
        }

        myTimer = object : CountDownTimer(60000, 1000) {
            override fun onTick(p0: Long) {
                Timber.i(p0.toString() + "is called from main activity")
            }
            override fun onFinish() {
                this.cancel()
            }
        }

        Timber.i("This is from onCreate() is called from main activity")
    }

    override fun onStart() {
        super.onStart()

        myTimer.start()

        Timber.i("This is from onStart() is called from main activity")
    }

    override fun onResume() {
        super.onResume()

        Timber.i("This is from onResume() is called from main activity")
    }

    override fun onPause() {
        super.onPause()

        Timber.i("This is from onPause is called from main activity")
    }

    override fun onStop() {
        super.onStop()

        myTimer.onFinish()

        Timber.i("This is from onStop is called from main activity")
    }

    override fun onDestroy() {
        super.onDestroy()

        Timber.i("This is from onDestroy is called from main activity")
    }
}