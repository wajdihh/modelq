package com.wajdihh.domain.interactor

import com.wajdihh.domain.executor.PostExecutionThread
import com.wajdihh.domain.executor.ThreadExecutor
import io.reactivex.Completable
import io.reactivex.CompletableObserver
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.disposables.Disposables
import io.reactivex.schedulers.Schedulers


abstract class CompletableUseCase<in Params> protected constructor(
        private val threadExecutor: ThreadExecutor,
        private val postExecutionThread: PostExecutionThread) {

    private val subscription = Disposables.empty()
    private val disposables = CompositeDisposable()

    /**
     * Builds a [Completable] which will be used when the current [CompletableUseCase] is executed.
     */
    protected abstract fun buildUseCaseObservable(params: Params? = null): Completable

    /**
     * Executes the current use case.
     */
    fun execute(singleObserver: CompletableObserver, params: Params? = null): Completable {
        val single =  this.buildUseCaseObservable(params)
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.scheduler)

        single.subscribe(singleObserver)

        return single
    }

    /**
     * Dispose from current [CompositeDisposable].
     */
    fun dispose() {
        if (!disposables.isDisposed) disposables.dispose()
    }

    /**
     * Dispose from current [CompositeDisposable].
     */
    private fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }
    /**
     * Unsubscribes from current [Disposable].
     */
    fun unsubscribe() {
        if (!subscription.isDisposed) {
            subscription.dispose()
        }
    }

}