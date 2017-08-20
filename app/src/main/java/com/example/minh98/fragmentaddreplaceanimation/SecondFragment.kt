package com.example.minh98.fragmentaddreplaceanimation

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by minh98 on 17/08/2017.
 */
class SecondFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view:View= inflater!!.inflate(R.layout.second_fragment,container,false)
        return view
    }
}