package com.example.myapplication.pages
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.myapplication.R
import androidx.fragment.app.Fragment

class NotificationFragment:Fragment(R.layout.fragment_notification){
    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textView = view.findViewById<TextView>(R.id.tv_notification)
        textView.text = "This is the notification Screen"
    }
}