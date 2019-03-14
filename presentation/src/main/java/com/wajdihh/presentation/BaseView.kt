package com.wajdihh.presentation

interface BaseView {

    /**
     * Mostly used in case of Fragment to check if it's attached to the activity
     * before entering in on success or on error to handle the UI components
     */
    fun isViewAttached() : Boolean

    /**
     * When progress is showing
     */
    fun onShowProgress()

    /**
     * When progress is hiding
     */
    fun onHideProgress()
}