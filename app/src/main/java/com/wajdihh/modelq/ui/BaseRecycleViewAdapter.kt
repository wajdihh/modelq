package com.wajdihh.modelq.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import com.wajdihh.modelq.R

/**
 * Created by wajdihh on 3/13/19.
 * Base adapter for recycleView
 */
abstract class BaseRecycleViewAdapter<T, VH : BaseRecycleViewHolder> : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var myList = ArrayList<T>()
    private val VIEW_TYPE_ITEM = 0
    private val VIEW_TYPE_LOADING = 1
    private var total = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE_ITEM) {
            val view = LayoutInflater.from(parent.context).inflate(getResourceLayout(), parent, false)
            createViewHolder(view)
        }else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_progressbar, parent, false)
            ViewHolderLoading(view)
        }

    }
    override fun getItemViewType(position: Int): Int {
        return if (position >= itemCount - 1 && itemCount < total) VIEW_TYPE_LOADING else VIEW_TYPE_ITEM
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is BaseRecycleViewHolder) {
            holder.setOnRecycleClickListener(object : BaseRecycleViewHolder.OnRecycleClickListener {
                override fun onClick(v: View, position: Int) {
                    mOnClickRowListener?.onClickRow(v, position)
                }
            })
            onIterateRow(holder as VH, position, myList[position])
        }else if (holder is ViewHolderLoading){
            holder.bindViewHolder()
            mOnLoadMoreListener?.onLoadMore()
        }

    }

    /**
     * Define size
     */
    override fun getItemCount(): Int = myList.size

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
    fun setList(list: ArrayList<T>) {
        this.myList = list
        notifyDataSetChanged()
    }

    /**
     * add list to list of Items (To use in case of pagination)
     */
    fun appendList(list: ArrayList<T>, totalItemToLoad: Int) {
        this.total = totalItemToLoad
        this.myList.addAll(list)
        notifyDataSetChanged()
    }

    fun getList(): ArrayList<T>? = this.myList


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

class ViewHolderLoading(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val progressBar : ProgressBar = itemView.findViewById(R.id.itemProgressbar)
    fun bindViewHolder() {
        progressBar.isIndeterminate = true
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