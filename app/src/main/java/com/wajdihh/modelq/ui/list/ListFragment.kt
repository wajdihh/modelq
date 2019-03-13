package com.wajdihh.modelq.ui.list

import com.wajdihh.modelq.R
import com.wajdihh.modelq.application.MyApplication
import com.wajdihh.modelq.ui.BaseFragment

/**
 * Created by wajdihh on 3/13/19.
 * ListFragment
 */
class ListFragment : BaseFragment() {

    companion object {
        fun newInstance() = ListFragment()
    }

    override fun getLayoutResources() = R.layout.fragment_list

    override fun onPostCreateView() {

        MyApplication.uiComponent.inject(this)
    }


}

