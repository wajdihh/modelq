package com.wajdihh.modelq.ui.list

import android.graphics.Color
import android.view.View
import android.widget.TextView
import com.wajdihh.modelq.R
import com.wajdihh.modelq.ui.BaseRecycleViewAdapter
import com.wajdihh.presentation.model.DemandItemUi
import java.util.*

/**
 * Created by wajdihh on 3/14/19.
 * Adapter for List
 */
class ListAdapter : BaseRecycleViewAdapter<DemandItemUi, ListViewHolder>() {

    /**
     * Get the layout used by the row
     */
    override fun getResourceLayout() = R.layout.rowlv

    override fun createViewHolder(view: View) = ListViewHolder(view)

    override fun onIterateRow(holder: ListViewHolder, position: Int, currentItem: DemandItemUi) {

        holder.title.text = currentItem.title
        holder.address.text = currentItem.address
        setIconView(holder.iconView)

    }


    private fun setIconView(view: TextView) {
        view.text = Random().nextInt(9).toString()
        val rnd = Random()
        val color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
        view.setBackgroundColor(color)
    }
}