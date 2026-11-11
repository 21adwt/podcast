package com.example.podcast
import android.content.Context
import android.net.Uri
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

/** 封装 ExoPlayer 的创建 / 播放 assets / 释放，Day 1 会在它上面加状态监听 */
class PlayerHolder @Inject constructor(
    @ApplicationContext private val appContext :Context
) {

    val player: ExoPlayer = ExoPlayer.Builder(appContext).build()



    fun playUrl(uri: Uri) {
        player.setMediaItem(MediaItem.fromUri(uri))
        player.prepare()
        player.play()
    }

    fun release() {
        player.release()
    }

}
