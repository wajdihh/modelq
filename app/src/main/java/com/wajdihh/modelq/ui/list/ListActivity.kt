package com.wajdihh.modelq.ui.list

import com.wajdihh.modelq.R
import com.wajdihh.modelq.ui.BaseActivity

class ListActivity : BaseActivity() {

    override fun getContentViewResources() = R.layout.activity_fragment

    override fun onPostCreateView(isNewInstance: Boolean) {
        if (isNewInstance) {
            setFragment(ListFragment.newInstance())
            setUpActionBar()
        }
    }

    private fun setUpActionBar() {
        supportActionBar?.apply {
            setTitle(R.string.list_title)
        }
    }

}
