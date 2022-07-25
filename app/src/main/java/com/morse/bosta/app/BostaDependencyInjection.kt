package com.morse.bosta.app

import android.app.Application
import com.morse.bosta.BuildConfig
import com.morse.bosta.data.repository.AlbumsRepository
import com.morse.bosta.data.repository.UserRepository
import com.morse.bosta.domain.repository.IAlbumsRepository
import com.morse.bosta.domain.repository.IUserRepository
import com.morse.bosta.remote.Api
import com.morse.bosta.remote.RetrofitCore
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApi() : Api = RetrofitCore.getGatewayAgent(BuildConfig.BASE_URL)

}

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppBindsModule {
    @Binds
    abstract fun injectUserRepository( userRepository: UserRepository ): IUserRepository
    @Binds
    abstract fun injectAlbumsRepository(albumsRepository: AlbumsRepository): IAlbumsRepository
}