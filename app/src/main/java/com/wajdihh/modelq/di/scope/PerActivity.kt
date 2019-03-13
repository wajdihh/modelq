package com.wajdihh.modelq.di.scope

import javax.inject.Scope

/**
 * Created by wajdihh on 3/13/19.
 *
 * To use between components and modules that belong to the same life cycle of and Activity or a fragment
 */
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerActivity