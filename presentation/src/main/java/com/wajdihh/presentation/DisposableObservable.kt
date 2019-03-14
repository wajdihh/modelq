package com.wajdihh.presentation

import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.observers.DisposableSingleObserver

/**
 * Created by wajdihh on 3/15/19.
 * custom observable
 */
open class MySingleObserver<T>(private val baseView: BaseView,
                               private val isShowProgress: Boolean = true) : DisposableSingleObserver<T>() {

    override fun onStart() {
        if (baseView.isViewAttached() && isShowProgress)
            baseView.onShowProgress()
    }

    override fun onSuccess(t: T) {
        if (baseView.isViewAttached() && isShowProgress)
            baseView.onHideProgress()
    }

    override fun onError(e: Throwable) {
        if (baseView.isViewAttached() && isShowProgress)
            baseView.onHideProgress()
    }

}

open class MyCompletableObserver(private val baseView: BaseView,
                                 private val isShowProgress: Boolean = true) : DisposableCompletableObserver() {


    override fun onStart() {
        if (baseView.isViewAttached() && isShowProgress)
            baseView.onShowProgress()
    }

    override fun onComplete() {
        if (baseView.isViewAttached() && isShowProgress)
            baseView.onHideProgress()
    }

    override fun onError(e: Throwable) {
        if (baseView.isViewAttached() && isShowProgress)
            baseView.onHideProgress()
    }

}