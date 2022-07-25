package com.morse.bosta.utils

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<B : ViewDataBinding> constructor(@LayoutRes val layoutRes: Int) :
    AppCompatActivity() {

    private var _binding: B? = null
    val binding: B by lazy { _binding!! }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = createDataBinding()
    }

    private fun createDataBinding() = DataBindingUtil.setContentView<B>(this, layoutRes)

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}