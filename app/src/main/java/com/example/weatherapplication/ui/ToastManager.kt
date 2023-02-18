package com.example.weatherapplication.ui

import android.content.Context
import android.widget.Toast

class ToastManager(private val context: Context) {
    fun showToast(messageId: Int){
        Toast.makeText(context, messageId, Toast.LENGTH_SHORT).show()
    }
}