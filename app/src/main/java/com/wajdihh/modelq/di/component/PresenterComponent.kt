package com.wajdihh.modelq.di.component

import com.wajdihh.modelq.di.module.PresenterModule
import com.wajdihh.modelq.di.scope.PerActivity
import com.wajdihh.modelq.ui.list.ListFragment
import dagger.Subcomponent

/**
 * Created by wajdihh on 3/13/19.
 * In this module we mentioned all methods of injection inside the Android app : Activity , fragment etc...
 */
@PerActivity
@Subcomponent(modules = [(PresenterModule::class)])
interface PresenterComponent {

    fun inject(target: ListFragment)
}