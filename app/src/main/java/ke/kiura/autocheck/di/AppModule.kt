package ke.kiura.autocheck.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ke.kiura.autocheck.AutoCheckApplication
import javax.inject.Singleton

/**
 * Application related binding
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): AutoCheckApplication {
        return app as AutoCheckApplication
    }

    @Provides
    @Singleton
    fun provideContext(app: AutoCheckApplication): Context {
        return app.applicationContext
    }
}