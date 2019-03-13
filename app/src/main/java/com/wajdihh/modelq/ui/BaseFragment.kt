package com.wajdihh.modelq.ui

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by wajdihh on 3/13/19.
 * The Base  fragment
 */

abstract class BaseFragment : Fragment() {


    private var mFragmentView: View? = null
    private var mContainerActivity: BaseActivity? = null
    /**
     * OnCreate
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        mContainerActivity = activity as BaseActivity
    }

    /**
     * On inflate layout from abstract method
     */
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        if (mFragmentView == null)
            mFragmentView = inflater?.inflate(getLayoutResources(), container, false)

        return mFragmentView!!
    }

    /**
     * On destroy view
     */
    override fun onDestroyView() {
        if (mFragmentView!!.parent != null) {
            (mFragmentView!!.parent as ViewGroup).removeView(mFragmentView)
        }
        super.onDestroyView()
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onPostCreateView()
    }

    /**
     * get layout xml
     */
    abstract fun getLayoutResources(): Int

    /**
     * In this method we initialize views (kotlin extension, findViewById ..) because in it we have the guarantee that
     * the main View was created
     */
    abstract fun onPostCreateView()

    /**
     * To test if fragment is attatached to the main activity to avoid
     * {Caused by: java.lang.IllegalStateException: Fragment  not attached to Activity}
     */
    fun isAttachedToMainActivity(): Boolean {
        return mContainerActivity != null && isAdded
    }

    fun showProgress () {
        mContainerActivity?.showProgress()
    }

    fun hideProgress () {
        mContainerActivity?.hideProgress()
    }
}