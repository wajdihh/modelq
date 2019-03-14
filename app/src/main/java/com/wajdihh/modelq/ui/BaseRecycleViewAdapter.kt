package com.wajdihh.modelq.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by wajdihh on 3/13/19.
 * Base adapter for recycleView
 */
abstract class BaseRecycleViewAdapter<T, VH : BaseRecycleViewHolder> : RecyclerView.Adapter<VH>() {

    private var myList: List<T>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context).inflate(getResourceLayout(), parent, false)
        return createViewHolder(view)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {

        holder.setOnRecycleClickListener(object : BaseRecycleViewHolder.OnRecycleClickListener {
            override fun onClick(v: View, position: Int) {
                mOnClickRowListener?.onClickRow(v, position)
            }
        })
        if (position >= itemCount - 1)
            mOnLoadMoreListener?.onLoadMore()

        if (myList != null)
            onIterateRow(holder, position, myList!![position])
        else
            throw IllegalArgumentException("You must set list of items before setting the adapter")
    }

    /**
     * Define size
     */
    override fun getItemCount(): Int = myList?.size ?: 0

    /**
     * Test if adapter is empty
     */
    fun isEmpty() = (itemCount == 0)

    /**
     * When adapter is creating his row , this method well be invoked, so inside in it
     * we map the data to viewHolder views
     */
    abstract fun onIterateRow(holder: VH, position: Int, currentItem: T)

    /**
     * Return the instance of used view Holder
     */
    abstract fun createViewHolder(view: View): VH

    /**
     * Get the layout used by the row
     */
    abstract fun getResourceLayout(): Int

    /**
     * Set list of Items
     */
    fun setList(list: List<T>) {
        this.myList = list
        notifyDataSetChanged()
    }

    fun getList(): List<T>? = this.myList


    /**
     * Listener of main adapter
     */
    private var mOnLoadMoreListener: OnLoadMoreListener? = null

    fun setOnLoadMoreListener(listener: OnLoadMoreListener) {
        mOnLoadMoreListener = listener
    }

    interface OnLoadMoreListener {
        /**
         * When to ask to load more items, when we reach the end scrolling
         */
        fun onLoadMore()
    }


    private var mOnClickRowListener: OnClickRowListener? = null
    fun setOnClickRowListener(listener: OnClickRowListener) {
        mOnClickRowListener = listener
    }

    interface OnClickRowListener {
        /**
         * When we click on Row we invoke this method
         */
        fun onClickRow(v: View, position: Int)
    }
}

open class BaseRecycleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private var mOnRecycleClickListener: OnRecycleClickListener? = null
    fun setOnRecycleClickListener(clickListener: OnRecycleClickListener) {
        this.mOnRecycleClickListener = clickListener
    }

    init {
        onRowBinding(view)
        view.setOnClickListener { v ->
            if (mOnRecycleClickListener != null) mOnRecycleClickListener?.onClick(v, adapterPosition)
        }
    }

    /**
     * Inside this method we bind the kotlin extension view with the variables
     */
    open fun onRowBinding(view: View) {}

    /**
     * To handle row clickListener
     */
    interface OnRecycleClickListener {

        fun onClick(v: View, position: Int)
    }
}