package com.wajdihh.modelq.application

import android.app.Application
import com.wajdihh.modelq.di.component.AppComponent
import com.wajdihh.modelq.di.component.DaggerAppComponent
import com.wajdihh.modelq.di.component.PresenterComponent
import com.wajdihh.modelq.di.module.AppModule
import com.wajdihh.modelq.di.module.PresenterModule

/**
 * Created by wajdihh on 3/13/19.
 * Main app
 */
class MyApplication : Application() {

    companion object {
        // uses for all call of singleton objects
        lateinit var appComponent: AppComponent
        // uses for injection inside fragments and activities
        lateinit var uiComponent: PresenterComponent
    }

    /**
     * OnCreate classic method
     */
    override fun onCreate() {
        super.onCreate()
        appComponent = initDagger()
        uiComponent = initUiComponent()
    }

    /**
     * Create main app component and initialize dagger lib
     */
    private fun initDagger(): AppComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()


    /**
     * Initialize ui component
     */
    private fun initUiComponent(): PresenterComponent
            = appComponent.plusPresenterComponent(PresenterModule())

}