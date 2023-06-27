package com.example.sensordemo

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PowerManager


class MainActivity : AppCompatActivity() {
    private lateinit var powerManager: PowerManager
    private lateinit var lock: PowerManager.WakeLock


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        powerManager = getSystemService(Context.POWER_SERVICE) as PowerManager
        lock = powerManager.newWakeLock(
            PowerManager.PROXIMITY_SCREEN_OFF_WAKE_LOCK,
            "simplewakelock:wakelocktag"
        )
        if(!lock.isHeld) lock.acquire()

        if(lock.isHeld) lock.release()
    }
}