package com.example.podcast

import android.net.Uri
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PlayerViewModel @Inject constructor(
    private val holder: PlayerHolder
): ViewModel() {
    val player get() = holder.player
    fun playUrl(uri : Uri) =holder.playUrl(uri)

    fun releaseSong() =holder.release()

    override fun onCleared() {
        holder.release()
    }
}
