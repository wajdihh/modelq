package com.wajdihh.modelq.ui.list

import com.wajdihh.modelq.R
import com.wajdihh.modelq.ui.BaseActivity

class ListActivity : BaseActivity() {

    override fun getContentViewResources() = R.layout.activity_fragment

    override fun onPostCreateView(isCreateInstance: Boolean) {
        if (isCreateInstance)
            setFragment(ListFragment.newInstance())
    }

}
