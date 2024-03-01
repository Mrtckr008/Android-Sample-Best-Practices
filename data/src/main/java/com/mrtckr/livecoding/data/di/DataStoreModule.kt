package com.mrtckr.livecoding.data.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.dataStoreFile
import com.mrtckr.common.network.AppDispatchers
import com.mrtckr.common.network.Dispatcher
import com.mrtckr.common.network.di.ApplicationScope
import com.mrtckr.livecoding.data.datastore.SongListSerializer
import com.mrtckr.livecoding.data.model.musicplayer.PlaylistListEntity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

    @Provides
    @Singleton
    internal fun providesSongListDataStore(
        @ApplicationContext context: Context,
        @Dispatcher(AppDispatchers.IO) ioDispatcher: CoroutineDispatcher,
        @ApplicationScope scope: CoroutineScope,
        songListSerializer: SongListSerializer,
    ): DataStore<PlaylistListEntity> = DataStoreFactory.create(
        serializer = songListSerializer,
        scope = CoroutineScope(scope.coroutineContext + ioDispatcher),
    ) {
        context.dataStoreFile("playlist_list.pb")
    }
}
