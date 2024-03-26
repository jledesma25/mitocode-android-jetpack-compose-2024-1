package com.mitocode.mitocodecoursecompose2024_i.di

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.mitocode.mitocodecoursecompose2024_i.data.repository.DishRepositoryImp
import com.mitocode.mitocodecoursecompose2024_i.data.repository.LoginRepositoryImp
import com.mitocode.mitocodecoursecompose2024_i.domain.repository.DishRepository
import com.mitocode.mitocodecoursecompose2024_i.domain.repository.LoginRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideSharePreferences(@ApplicationContext context: Context) : SharedPreferences{

        val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)

        return EncryptedSharedPreferences.create(
            "PREFERENCES_TOKEN",
            masterKeyAlias,
            context,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )

    }

    @Provides
    @Singleton
    fun provideLoginRepository(sharedPreferences: SharedPreferences) : LoginRepository{
        return LoginRepositoryImp(sharedPreferences)
    }

    @Provides
    @Singleton
    fun provideDishRepository(sharedPreferences: SharedPreferences) : DishRepository{
        return DishRepositoryImp(sharedPreferences)
    }

}