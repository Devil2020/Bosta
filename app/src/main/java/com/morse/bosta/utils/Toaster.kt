package com.morse.bosta.utils

import android.content.Context
import android.widget.Toast

object Toaster {
    fun showError ( context: Context , message : String){
        Toast.makeText(context , message , Toast.LENGTH_LONG).show()
    }
}