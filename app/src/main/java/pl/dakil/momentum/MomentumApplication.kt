package pl.dakil.momentum

import android.app.Application
import pl.dakil.momentum.data.di.DataDiModule
import pl.dakil.momentum.data.di.LocalDataDiModule

class MomentumApplication : Application() {
    /**
     * A module that provides dependency injection
     */
    lateinit var diModule: DataDiModule
        private set

    override fun onCreate() {
        super.onCreate()
        diModule = LocalDataDiModule(this)
    }
}