package com.wajdihh.modelq.di.component

import com.wajdihh.modelq.di.module.AppModule
import com.wajdihh.modelq.di.module.DataFactoryModule
import com.wajdihh.modelq.di.module.DomainRepositoryModule
import com.wajdihh.modelq.di.module.PresenterModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by wajdihh on 3/13/19.
 * This is the main component of the DI
 */
@Singleton
@Component(modules = [(AppModule::class), (DataFactoryModule::class), (DomainRepositoryModule::class)])
interface AppComponent {

    /**
     * To add the Presenter SUB COMPONENT
     */
    fun plusPresenterComponent(presenterModule: PresenterModule): PresenterComponent
}