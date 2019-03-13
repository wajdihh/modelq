package com.wajdihh.modelq.ui

import android.app.Fragment
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.wajdihh.modelq.R

/**
 * Created by wajdihh on 3/13/19.
 * My Base activity
 */
abstract class BaseActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // get layout xml
        setContentView(getContentViewResources())

        onPostCreateView(savedInstanceState == null)
    }

    /**
     * get activity xml
     */
    abstract fun getContentViewResources(): Int

    /**
     * In this method we initialize views (kotlin extension, findViewById ..) because in it we have the guarantee that
     * the main View was created
     */
    abstract fun onPostCreateView(isCreateInstance: Boolean)


    /**
     * Set fragment and Add it to the backStack
     */
    fun setFragment(pFragment: Fragment) {
        setFragmentOp(pFragment, "", true)
    }

    /**
     * Set fragment WITHOUT ADDING it to the backStack
     */
    fun setFragmentNoBack(pFragment: Fragment) {
        setFragmentOp(pFragment, "", false)
    }

    /**
     * Set fragment WITHOUT ADDING it to the backStack + possibility to add a custom tag
     */
    fun setFragmentNoBack(pFragment: Fragment, tag: String) {
        setFragmentOp(pFragment, tag, false)
    }

    /**
     * Set fragment with options
     */
    private fun setFragmentOp(pFragment: Fragment, tag: String, isAddToBackStack: Boolean) {

        val fragTrs = fragmentManager.beginTransaction().replace(R.id.fragment_container, pFragment, tag)
        if (isAddToBackStack) fragTrs.addToBackStack(null)
        fragTrs.commit()
    }

}