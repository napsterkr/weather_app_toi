package com.example.myassignment.utility

import android.annotation.SuppressLint
import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter

object BindingAdapters {

    @JvmStatic
    @BindingAdapter("visibleGoneBoolean")
    fun visibleGoneBoolean(view: View, show: Boolean?) {
        view.visibility = if (show != null && show) View.VISIBLE else View.GONE
    }

    @JvmStatic
    @BindingAdapter("showHideUI")
    fun showHideUI(view: View, show: Boolean) {
        view.visibility = if (show != null && !show ) View.VISIBLE else View.GONE
    }


    @JvmStatic
    @BindingAdapter("temperature")
    fun temperature(view: TextView, temperature: String) {
        view.text=(temperature)+" \u2103"

    }
}