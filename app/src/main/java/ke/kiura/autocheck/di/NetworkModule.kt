package ke.kiura.autocheck.di

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ke.kiura.autocheck.AutoCheckApplication
import ke.kiura.autocheck.core.DefaultConfig
import ke.kiura.autocheck.network.Endpoints
import ke.kiura.autocheck.network.RetrofitService
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Network related dependency injection
 */
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    // provide gson with duration formatting
    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient, gson: Gson): Retrofit.Builder {
        return Retrofit
            .Builder()
            .baseUrl(Endpoints.API_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
    }

    @Provides
    @Singleton
    fun providesLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    @Singleton
    fun providesOkhttpInterceptor(
        app: AutoCheckApplication // auth tokens can be added here
    ): Interceptor {
        return Interceptor { chain: Interceptor.Chain ->
            val original: Request = chain.request()
            val requestBuilder: Request.Builder = original.newBuilder()
                .addHeader("Accept", "Application/JSON")
            val request: Request = requestBuilder.build()
            chain.proceed(request)
        }
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        cache: Cache,
        loggingInterceptor: HttpLoggingInterceptor,
        interceptor: Interceptor
    ): OkHttpClient {

        val okHttpClientBuilder = OkHttpClient().newBuilder()
        okHttpClientBuilder.connectTimeout(DefaultConfig.CONNECTION_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(DefaultConfig.READ_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(DefaultConfig.WRITE_TIMEOUT, TimeUnit.SECONDS)
            .cache(cache)
            .addNetworkInterceptor(loggingInterceptor)
            .addInterceptor(interceptor)
        return okHttpClientBuilder.build()
    }

    @Provides
    @Singleton
    internal fun provideCache(context: Context): Cache {
        val httpCacheDirectory = File(context.cacheDir.absolutePath, "HttpCache")
        return Cache(httpCacheDirectory, DefaultConfig.CACHE_SIZE_BYTES)
    }

    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit.Builder): RetrofitService {
        return retrofit
            .build()
            .create(RetrofitService::class.java)
    }

    @Provides
    @Singleton
    fun provideBaseUrl(): String {
        return Endpoints.API_URL
    }
}