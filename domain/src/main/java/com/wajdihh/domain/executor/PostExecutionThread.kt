package com.wajdihh.domain.executor

/**
 * Created by wajdihh on 3/11/19.
 *
 * Thread abstraction created to change the execution context from any thread to any other thread.
 * Useful to encapsulate a UI Thread for example, since some job will be done in background, an
 * implementation of this interface will change context and update the UI.
 */
import io.reactivex.Scheduler

interface PostExecutionThread {
    val scheduler: Scheduler
}