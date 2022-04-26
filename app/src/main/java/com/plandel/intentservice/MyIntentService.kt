package com.plandel.intentservice

import android.app.IntentService
import android.content.Intent
import android.util.Log
import kotlin.concurrent.thread

class MyIntentService : IntentService("MyIntentService"){

    init {
        instance = this
    }

    companion object {
        private lateinit var instance: MyIntentService
        var isRunning = false
        
        fun stopService() {
            Log.d("MyIntent", "Service is stopping...")
            isRunning = false
            instance.stopSelf()
        }
    }

    override fun onHandleIntent(p0: Intent?) {
        try {
            isRunning = true
            while (isRunning) {
                Log.d("MyIntent", "Service is running...")
                Thread.sleep(1000)
            }
        }catch (e: InterruptedException) {
            Thread.currentThread().interrupt()
        }
    }

}