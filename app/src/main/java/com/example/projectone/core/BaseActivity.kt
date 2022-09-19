package com.example.projectone.core

import android.os.Bundle
import android.os.PersistableBundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding


abstract class BaseActivity<in T>(@LayoutRes private val layoutResId: Int? = null): AppCompatActivity() where T: ViewDataBinding {

    abstract fun onActivityCreated(dataBinder: T)

    final override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        this@BaseActivity.initial()
    }

    final override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this@BaseActivity.initial()
    }

    private fun initial() {
        this@BaseActivity.layoutResId?.let { layoutId ->
            val dataBinder = DataBindingUtil.setContentView<T>(this@BaseActivity, layoutId)
            this@BaseActivity.onActivityCreated(dataBinder)
        }
    }

}
