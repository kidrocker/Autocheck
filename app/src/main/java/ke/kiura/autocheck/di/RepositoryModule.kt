package ke.kiura.autocheck.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ke.kiura.autocheck.data.repository.detail.DetailRepo
import ke.kiura.autocheck.data.repository.detail.DetailRepoImpl
import ke.kiura.autocheck.data.repository.landing.LandingRepo
import ke.kiura.autocheck.data.repository.landing.LandingRepoImpl
import ke.kiura.autocheck.data.repository.media.MediaRepo
import ke.kiura.autocheck.data.repository.media.MediaRepoImpl
import ke.kiura.autocheck.network.RetrofitService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideLandingRepo(
        retrofitService: RetrofitService
    ):LandingRepo{
        return LandingRepoImpl(retrofitService)
    }

    @Provides
    @Singleton
    fun provideDetailRepo(
        retrofitService: RetrofitService
    ):DetailRepo{
        return DetailRepoImpl(retrofitService)
    }

    @Provides
    @Singleton
    fun  provideMediaRepo(
        retrofitService: RetrofitService
    ):MediaRepo{
        return MediaRepoImpl(retrofitService)
    }
}