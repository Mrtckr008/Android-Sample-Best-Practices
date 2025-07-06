package com.mrtckr.livecoding.feature.musicplayer.service

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.IBinder
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
class MusicServiceConnection(context: Context) {
    private val _serviceBinder = mutableStateOf<MusicPlayerService.MusicServiceBinder?>(null)
    val serviceBinder: MutableState<MusicPlayerService.MusicServiceBinder?> = _serviceBinder

    private var isBound = false

    private val serviceConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            _serviceBinder.value = service as MusicPlayerService.MusicServiceBinder
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            _serviceBinder.value = null
        }
    }

    init {
        bind(context)
    }

    private fun bind(context: Context) {
        if (!isBound) {
            val intent = Intent(context, MusicPlayerService::class.java)
            context.bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE)
            isBound = true
        }
    }

    fun unbindService(context: Context) {
        if (isBound) {
            try {
                context.unbindService(serviceConnection)
            } catch (_: IllegalArgumentException) { }
            isBound = false
        }
    }
}