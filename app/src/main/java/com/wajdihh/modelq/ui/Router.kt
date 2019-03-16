package com.wajdihh.modelq.ui

import android.content.Context
import android.content.Intent
import com.wajdihh.modelq.ui.detail.DetailActivity

/**
 * Created by wajdihh on 3/16/19.
 * To set navigation between acts and frags
 */
class Router {
    companion object {

        fun navigateToDetail(context: Context, id: Int) {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.ARG_DEMAND_ID, id)
            context.startActivity(intent)
        }
    }
}