package com.wajdihh.modelq.ui.list

import android.view.View
import android.widget.TextView
import com.wajdihh.modelq.ui.BaseRecycleViewHolder
import kotlinx.android.synthetic.main.rowlv.view.*

/**
 * Created by wajdihh on 3/14/19.
 * View holder
 */
class ListViewHolder(view: View) : BaseRecycleViewHolder(view) {

    lateinit var title: TextView
    lateinit var address: TextView
    lateinit var iconView: TextView

    override fun onRowBinding(view: View) {
        title = view.demandTitle
        address = view.demandAddress
        iconView = view.demandIcon
    }
}