package com.wajdihh.modelq.ui

import android.app.Fragment
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.wajdihh.modelq.R
import com.wajdihh.modelq.extension.hide
import com.wajdihh.modelq.extension.show
import kotlinx.android.synthetic.main.activity_fragment.*

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

    fun showProgress () {
        base_progress?.let { it.show() }
    }

    fun hideProgress () {
        base_progress?.let { it.hide() }
    }

    /**
     * get activity xml
     */
    abstract fun getContentViewResources(): Int

    /**
     * In this method we initialize views (kotlin extension, findViewById ..) because in it we have the guarantee that
     * the main View was created
     */
    abstract fun onPostCreateView(isNewInstance: Boolean)


    /**
     * Set fragment with options
     */
    fun setFragment(pFragment: Fragment) {
        val fragTrs = fragmentManager.beginTransaction().replace(R.id.fragment_container, pFragment)
        fragTrs.commit()
    }

}