package com.example.lib

import android.content.Context
import android.content.SharedPreferences
import android.hardware.display.DisplayManager
import android.net.ConnectivityManager
import android.net.wifi.WifiManager
import android.os.Handler
import android.os.Looper
import android.preference.PreferenceManager
import android.telephony.TelephonyManager
import android.view.ViewConfiguration
import android.view.accessibility.AccessibilityManager
import android.view.accessibility.CaptioningManager
import android.view.inputmethod.InputMethodManager
import androidx.core.content.getSystemService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AndroidModule {
    @Provides
    fun provideTelephonyManager(
        @ApplicationContext context: Context
    ): TelephonyManager = context.getSystemService()!!

    @Provides
    fun provideConnectivityManager(
        @ApplicationContext context: Context
    ): ConnectivityManager = context.getSystemService()!!

    @Provides
    fun provideWifiManager(
        @ApplicationContext context: Context
    ): WifiManager = context.getSystemService()!!

    @Provides
    @Singleton
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        @Suppress("DEPRECATION")
        return PreferenceManager.getDefaultSharedPreferences(context)
    }

    @Provides
    @Singleton
    fun provideViewConfiguration(
        @ApplicationContext context: Context
    ): ViewConfiguration = ViewConfiguration.get(context)

    @Provides
    @Singleton
    fun provideAccessibilityManager(
        @ApplicationContext context: Context
    ): AccessibilityManager = context.getSystemService()!!

    @Provides
    fun provideHandler(): Handler = Handler(Looper.getMainLooper())

    @Provides
    fun provideInputMethodManager(
        @ApplicationContext context: Context
    ): InputMethodManager = context.getSystemService()!!

    @Provides
    @Singleton
    fun provideDisplayManager(
        @ApplicationContext context: Context
    ): DisplayManager = context.getSystemService()!!

    @Provides
    fun provideCaptioningManager(
        @ApplicationContext context: Context
    ): CaptioningManager = context.getSystemService()!!
}
