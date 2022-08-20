package com.morse.bosta.app

import android.app.Application
import android.os.Build
import android.os.StrictMode
import androidx.annotation.RequiresApi
import com.morse.bosta.BuildConfig
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BostaApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        if (!BuildConfig.isTest) {
            //
            StrictMode.setThreadPolicy(
                StrictMode.ThreadPolicy.Builder()
                    .detectNetwork()
                    .detectCustomSlowCalls()
                    .penaltyLog()
                    .penaltyDialog()
                    .build()
            )

            StrictMode.setVmPolicy(
                StrictMode.VmPolicy.Builder()
                    .detectActivityLeaks()
                    .detectLeakedClosableObjects()
                    .detectLeakedRegistrationObjects()
                    .penaltyLog()
                    .penaltyDropBox()
                    .build()
            )

        }
    }

}