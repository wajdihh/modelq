package com.wajdihh.modelq.ui.detail

import android.view.MenuItem
import com.wajdihh.modelq.R
import com.wajdihh.modelq.ui.BaseActivity

/**
 * Created by wajdihh on 3/16/19.
 * Details activity
 */
class DetailActivity : BaseActivity() {

    companion object {
        const val ARG_DEMAND_ID = "ARG_DEMAND_ID"
    }

    override fun getContentViewResources() = R.layout.activity_fragment

    override fun onPostCreateView(isNewInstance: Boolean) {
        if (isNewInstance) {
            val id = intent.getIntExtra(ARG_DEMAND_ID, 0)
            setFragment(DetailFragment.newInstance(id))
            setUpActionBar()
        }
    }

    private fun setUpActionBar() {
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setTitle(R.string.details_title)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                //To add custom action
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}