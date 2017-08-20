package com.example.minh98.fragmentaddreplaceanimation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView

class MainActivity : AppCompatActivity(),FirstFragment.onClickFragmentListener {
    override fun clicked() {
        showSecondFragment()
    }

    lateinit var mFirstFragment: FirstFragment
    lateinit var mSecondFragment:SecondFragment
    var tvFirst:TextView?=null
    var tvSecond:TextView?=null
    var tvFirstIsCheck=true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /**
         *  su dung cach add fragment> show,hide...
         */
//        initFragment()
//        //show fragment 1
//        showFirstFragment()
        /**
         * su dung cach replace truc tiep cac view tu containerView
         */
        initFragment()
        showFirstFragment()
        tvFirst= findViewById(R.id.tvFirst) as TextView
        tvSecond= findViewById(R.id.tvSecond) as TextView

        tvFirst?.setOnClickListener {
            firstSelected()
            showFirstFragment() }

        tvSecond?.setOnClickListener {
            secondSelected()
            showSecondFragment() }
    }

    private fun firstSelected(){
        tvFirst?.setBackgroundResource(R.drawable.bg_selected)
        tvSecond?.setBackgroundResource(R.drawable.bg_un_selected)
        tvFirstIsCheck=true
    }

    private fun secondSelected(){
        tvSecond?.setBackgroundResource(R.drawable.bg_selected)
        tvFirst?.setBackgroundResource(R.drawable.bg_un_selected)
        tvFirstIsCheck=false
    }

    private fun initFragment() {
        mFirstFragment=FirstFragment().apply { listener=this@MainActivity }
        mSecondFragment= SecondFragment()
    }

    private fun showFirstFragment() {
        supportFragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.left_in,R.anim.left_out)
                .replace(R.id.main_layout,mFirstFragment,FirstFragment::class.java.name)
                .commit()
        firstSelected()
    }
    private fun showSecondFragment(){
        supportFragmentManager.beginTransaction()
                .addToBackStack(null)
                .setCustomAnimations(R.anim.right_in,R.anim.right_out,R.anim.left_in,R.anim.left_out)
                .replace(R.id.main_layout,mSecondFragment,SecondFragment::class.java.name)
                .commit()
        secondSelected()
    }

    override fun onBackPressed() {
        if(!tvFirstIsCheck) {
            firstSelected()
            tvFirstIsCheck=true
        }
        super.onBackPressed()
    }


    /*
    private fun showFirstFragment() {
        supportFragmentManager.beginTransaction()
                .show(mFirstFragment)
                .hide(mSecondFragment).commit()
    }

    private fun showSecondFragment() {
        supportFragmentManager.beginTransaction()
                .addToBackStack(null)
                .show(mSecondFragment)
                .hide(mFirstFragment).commit()
    }


    private fun initFragment() {
        mFirstFragment= FirstFragment()
        mFirstFragment.listener=this
        mSecondFragment= SecondFragment()
        supportFragmentManager.beginTransaction()
                .add(R.id.main_layout,mFirstFragment,FirstFragment::class.java.name)
                .add(R.id.main_layout,mSecondFragment,SecondFragment::class.java.name)
                .commit()
    }
    */
}
